package org.example;

import java.util.Stack;

public class UserPool {
    private final Stack<User> pool = new Stack<>();
    private final int maxPoolSize;

    // Constructor
    public UserPool(int maxPoolSize) {
        this.maxPoolSize = maxPoolSize;
    }

    public User acquireUser(String name, int age) {
        if (!pool.isEmpty()) {
            // Reuse an existing user if available
            User user = pool.pop();
            return new User(name, age); // Replace with actual reuse if possible
        }
        // Create a new user if the pool is empty
        return new User(name, age);
    }

    public void releaseUser(User user) {
        if (pool.size() < maxPoolSize) {
            // Return the user to the pool
            pool.push(user);
        }
    }
}
