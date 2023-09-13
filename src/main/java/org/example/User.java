package org.example;

public class User {

    private final int id;
    private final String name;
    private final String email;

    public User(UserBuilder build)
    {
        this.id = build.id;
        this.name = build.name;
        this.email = build.email;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    static class UserBuilder
    {
        private int id;
        private String name;
        private String email;

        public UserBuilder setId(int id) {
            this.id = id;
            return this;
        }

        public UserBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public UserBuilder setEmail(String email) {
            this.email = email;
            return this;
        }

        public User build()
        {
            User user = new User(this);
            return user;
        }
    }
}
