public interface SkinConsultationManager {
    void addPerson();
    void deletePerson();
    default String capitalizeFirstLetter(String string){
        String firstLetter = string.substring(0,1).toUpperCase();
        return firstLetter + string.substring(1);
    }
}