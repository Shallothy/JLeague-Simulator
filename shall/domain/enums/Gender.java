package shall.domain.enums;

public enum Gender {
    GENDER_MALE('M'),
    GENDER_FEMALE('F');

    final char gender;
    Gender(char gender) {
        this.gender = Character.toUpperCase(gender);
    }
    public char getGender(){
        return this.gender;
    }
}
