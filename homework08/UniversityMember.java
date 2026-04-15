// Noah Thompson
// 14 April 2026
// UniversityMember.java
public abstract class UniversityMember{
    private String name;
    private String id;
    private String email;

    // public constructor taking name id and email
    public UniversityMember(String name, String id, String email){
        if (name == null || id == null || email == null){
            throw new IllegalArgumentException("UniversityMember parameters cannot be null");
        }
        this.name = name;
        this.id = id;
        this.email = email;
    }

    // abstract method getRole
    public abstract String getRole();

    // getter methods
    public String getName(){
        return this.name;
    }

    public String getId(){
        return this.id;
    }

    public String getEmail(){
        return this.email;
    }
}