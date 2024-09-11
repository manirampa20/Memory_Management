package org.example;

public class UserManager {
    private final UserPool userPool;

    public UserManager(UserPool userPool) {
        this.userPool = userPool;
    }

    public void createUser(String name, int age) {
        User user = userPool.acquireUser(name, age);
        System.out.println("Created: " + user);
        // Simulate some operations with the user
        // Return the user to the pool
        userPool.releaseUser(user);
    }

    public static void main(String[] args) {
        UserPool pool = new UserPool(5);
        UserManager manager = new UserManager(pool);

         //Create and manage users
        manager.createUser("Alice", 30);
        manager.createUser("Bob", 25);
        manager.createUser("Charlie", 35);
    }
}
