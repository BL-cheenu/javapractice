package com.bl.day27.io.problem;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class EmployeePayrollServiceMain {
    private static final Map<WatchKey, Path> keyMap = new HashMap<>();


    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Employee Id: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter Employee Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Employee Salary: ");
        double salary = scanner.nextDouble();

        EmployeePayrollService payrollService = new EmployeePayrollService(id, name, salary);
        System.out.println("--- Employee Payroll Details ---");
        payrollService.display();

        String directoryPath = "EmployeeData";
        String filePath = directoryPath + "/employee.txt";

        File directory = new File(directoryPath);
        File file = new File(filePath);

        System.out.println("File exist: " + file.exists());
        if (!directory.exists()) {
            System.out.println("File exists: " + directory.mkdir());
        }

        try {
            if (!file.createNewFile()) {
                System.out.println("Empty file created");
            } else {
                System.out.println("File already exists");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Listing files & directories: ");
        File[] files = directory.listFiles();
        if (files != null) {
            for (File f : files) {
                System.out.println(f.getName());
            }
        }

        System.out.println("Listing .txt files: ");
        if (files != null) {
            for (File f : files) {
                if (f.isFile() && f.getName().endsWith(".txt")) {
                    System.out.println(f.getName());
                }
            }
        }

//        if (file.delete()) {
//            System.out.println("File deleted successfully");
//        }
        System.out.println("File exists after deletion: " + file.exists());

        WatchService watchService = null;
        try {
            watchService = FileSystems.getDefault().newWatchService();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        registerAll(Paths.get(directoryPath), watchService);

        countEntries(directory);

        System.out.println("Watching directory for changes (Press Ctrl+C to stop)...");

        while (true) {
            WatchKey key = null;
            try {
                key = watchService.take();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            Path dir = keyMap.get(key);

            for (WatchEvent<?> event : key.pollEvents()) {
                Path changed = dir.resolve((Path) event.context());
                System.out.println(event.kind().name() + " : " + changed);

                if (event.kind() == StandardWatchEventKinds.ENTRY_CREATE &&
                        Files.isDirectory(changed)) {
                    registerAll(changed, watchService);
                }
            }
            key.reset();


        }
    }

    private static void countEntries(File directory) {
        int count = 0;
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                count++;
                if (file.isDirectory() && file.listFiles() != null) {
                    count += file.listFiles().length;
                }
            }
        }
        System.out.println("Total entries (files + directories): " + count);
    }

    private static void registerAll(Path start, WatchService watchService) throws IOException {
        Files.walk(start)
                .filter(Files::isDirectory)
                .forEach(path -> {
                    try {
                        WatchKey key = path.register(
                                watchService,
                                StandardWatchEventKinds.ENTRY_CREATE,
                                StandardWatchEventKinds.ENTRY_DELETE,
                                StandardWatchEventKinds.ENTRY_MODIFY
                        );
                        keyMap.put(key, path);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
    }
}
