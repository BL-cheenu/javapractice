package com.bl.day27.io.problem;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.util.HashMap;
import java.util.Map;

public class DirectoryWatchService {
    private static final Map<WatchKey, Path> keyMap = new HashMap<>();

    public static void watchDirectory(String directoryPath) throws Exception {

        WatchService watchService = FileSystems.getDefault().newWatchService();
        registerAll(Paths.get(directoryPath), watchService);

        System.out.println("Watching directory for changes...");

        while (true) {
            WatchKey key = watchService.take();
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

    public static void countEntries(File directory) {
        int count = 0;
        File[] files = directory.listFiles();

        if (files != null) {
            for (File f : files) {
                count++;
                if (f.isDirectory() && f.listFiles() != null) {
                    count += f.listFiles().length;
                }
            }
        }
        System.out.println("Total entries (files + directories): " + count);
    }
}
