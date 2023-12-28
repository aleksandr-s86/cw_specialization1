import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class AnimalRegistry {
    private Map<String, Animal> animals;
    private Scanner scanner;

    public AnimalRegistry() {
        animals = new HashMap<>();
        scanner = new Scanner(System.in);
    }
public void run() {
        while (true) {
            showMenu();
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    createAnimal();
                    break;
                case "2":
                    showCommands();
                    break;
                case "3":
                    trainAnimal();
                    break;
                case "4":
                    return;
                default:
                    System.out.println("Неправильный выбор. Попробуйте еще раз.");
                    break;
            }
        }
    }
    private void showMenu() {
        System.out.println("Меню:");
        System.out.println("1. Завести новое животное");
        System.out.println("2. Показать список команд животного");
        System.out.println("3. Обучить животное новым командам");
        System.out.println("4. Выход");
        System.out.print("Выберите пункт меню: ");
    }

    private void createAnimal() {
        System.out.print("Введите имя животного: ");
    String name = scanner.nextLine();
    System.out.print("Введите день рождения животного: ");
    String birthday = scanner.nextLine();
    System.out.print("Введите тип животного (собака, кошка, хомяк, лошадь, верблюд, ослик): ");
    String animalType = scanner.nextLine();

    Animal animal;
    if (animalType.equalsIgnoreCase("собака")) {
        animal = new Dog(name, birthday);
    } else if (animalType.equalsIgnoreCase("кошка")) {
        animal = new Cat(name, birthday);
    } else if (animalType.equalsIgnoreCase("хомяк")) {
        animal = new Hamster(name, birthday);
    } else if (animalType.equalsIgnoreCase("лошадь")) {
        animal = new Horse(name, birthday);
    } else if (animalType.equalsIgnoreCase("верблюд")) {
        animal = new Camel(name, birthday);
    } else if (animalType.equalsIgnoreCase("ослик")) {
        animal = new Donkey(name, birthday);
    } else {
        System.out.println("Неправильный тип животного.");
        return;
    }

    animals.put(name, animal);
    System.out.println("Животное добавлено.");
    }

    private void showCommands() {
        System.out.print("Введите имя животного: ");
        String name = scanner.nextLine();

        Animal animal = animals.get(name);
        if (animal != null) {
            List<String> commands = animal.getCommands();
            if (!commands.isEmpty()) {
                System.out.println("Список команд для животного " + name + ":");
                for (String command : commands) {
                    System.out.println(command);
                }
            } else {
                System.out.println("У животного нет команд.");
            }
        } else {
            System.out.println("Животное не найдено.");
        }
    }

    private void trainAnimal() {
        System.out.print("Введите имя животного: ");
        String name = scanner.nextLine();

        Animal animal = animals.get(name);
        if (animal != null) {
            System.out.print("Введите новую команду для животного: ");
            String command = scanner.nextLine();
            animal.addCommand(command);
            System.out.println("Команда добавлена.");
        } else {
            System.out.println("Животное не найдено.");
        }
    }

   
}