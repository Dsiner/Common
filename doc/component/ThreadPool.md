------ TaskScheduler ThreadPool ------

1. Features
```java
    1).TaskScheduler.postMain(...);        // Main thread, executing task
    2).TaskScheduler.postMainDelayed(...); // Main thread, executing task
    3).TaskScheduler.executeMain(...);     // Main thread, executing task
    4).TaskScheduler.executeTask(...);     // Asynchronous thread, executing tasks in the thread pool
    5).TaskScheduler.executeSingle(...);   // Asynchronous thread, executing tasks in the single-threaded thread pool
    6).TaskScheduler.create(...);          // Task scheduling
```

2. Task scheduling
```java
    1)..func(...).func(...).func(...)...: Sequential flow execution
    2)..observeOn(...): Thread switching
    3).----- Demo -----
        TaskScheduler.create(new Task<List<String>>() {
            @Override
            public List<String> run() {
                ...do something in io thread
                return new ArrayList<>();
            }
        }).subscribeOn(Schedulers.io())
                .observeOn(Schedulers.newThread())
                .map(new Function<List<String>, String>() {
                    @Override
                    public String apply(@NonNull List<String> strings) throws Exception {
                        ...do something in new thread
                        return "";
                    }
                })
                .observeOn(Schedulers.io())
                .map(new Function<String, Boolean>() {
                    @Override
                    public Boolean apply(@NonNull String s) throws Exception {
                        ...do something in io thread
                        return true;
                    }
                })
                .observeOn(Schedulers.mainThread())
                .subscribe(new Observer<Boolean>() {
                    @Override
                    public void onNext(@NonNull Boolean result) {
                        ...do something in main thread
                    }

                    @Override
                    public void onError(Throwable e) {
                        ...do something in main thread
                    }
                });
```
