package shall.domain.enums;

public enum SubCategory {
    CHILDREN(6,12,"Children"),
    JUVENILE(13,17,"Juvenile"),
    PROFESSIONAL(18,45,"Professional");
    private String description;
    private final int minAge;
    private final int maxAge;

    SubCategory(int minAge, int maxAge, String description){
        this.minAge =minAge;
        this.maxAge =maxAge;
        this.description =description;
    }

    public boolean isWithinCategory(int age){ return age>=minAge && age<=maxAge; }

    public String getDescription() {
        return description;
    }

}
