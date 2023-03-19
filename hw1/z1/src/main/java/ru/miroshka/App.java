package ru.miroshka;

public class App {
    public static void main(String[] args) {
        Person tempPerson = new Person.Builder()
                .setAddress("Тюменская область г.Тюмень ул.Коретная дом 66")
                .setGender("Мужской")
                .setPhone("+79044623256")
                .setAge(33)
                .setCountry("Россия")
                .setFirstName("Игорь")
                .setLastName("Мирощниченко")
                .setMiddleName("Валерьевич")
                .build();

        System.out.println(tempPerson);
    }
}
