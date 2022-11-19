import java.util.*;

public class Main {
    public static void printMenu() {
        System.out.println("""
                /r - choose random student
                /l - list of student with grades
                /h - help
                /q - quit""");
    }

    public static void main(String[] args) {
        List<StudentAttentionInfo> studentAttentionInfoPool = new ArrayList<>();
        studentAttentionInfoPool.add(new StudentAttentionInfo("Rachel Frazier"));
        studentAttentionInfoPool.add(new StudentAttentionInfo("Megan Mccoy"));
        studentAttentionInfoPool.add(new StudentAttentionInfo("Beatrice Cunningham"));
        studentAttentionInfoPool.add(new StudentAttentionInfo("Darren Clark"));
        studentAttentionInfoPool.add(new StudentAttentionInfo("Marjorie Anderson"));
        studentAttentionInfoPool.add(new StudentAttentionInfo("Philip Craig"));

        List<StudentAttentionInfo> studentAttentionInfoUsed = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);
        Random rand = new Random();

        printMenu();
        while (true) {
            switch (scanner.nextLine()) {
                case "/h" -> printMenu();
                case "/r" -> {
                    if (studentAttentionInfoPool.size() == 0) {
                        System.out.println("Студентов, которые не отвечали на вопросы, больше нет");
                        break;
                    }
                    int index = rand.nextInt(studentAttentionInfoPool.size());
                    StudentAttentionInfo studentAttentionInfo = studentAttentionInfoPool.get(index);
                    System.out.println("Отвечает " + studentAttentionInfo.getName());
                    System.out.println("Присутствует ли на паре?");
                    studentAttentionInfo.setPresent(scanner.nextLine().equalsIgnoreCase("y"));
                    if (studentAttentionInfo.isPresent()) {
                        while (true) {
                            System.out.println("Введите оценку:");
                            try {
                                studentAttentionInfo.setGrade(Integer.parseInt(scanner.nextLine()));
                                break;
                            } catch (NumberFormatException e) {
                                System.out.println("Некорректный ввод");
                            }
                        }
                        System.out.println(studentAttentionInfo.getName() + " присутствовал(а) и добавлен(а) в ведомость");
                    } else {
                        System.out.println(studentAttentionInfo.getName() + " не присутствовал(а) и добавлен(а) в ведомость");
                    }
                    studentAttentionInfoPool.remove(index);
                    studentAttentionInfoUsed.add(studentAttentionInfo);
                }
                case "/l" -> {
                    for (StudentAttentionInfo studentAttentionInfo : studentAttentionInfoUsed) {
                        System.out.println(studentAttentionInfo);
                    }
                }
                case "/q" -> System.exit(0);
                default -> System.out.println("Такой  команды не существует. Введите /h для просмотра списка команд.");
            }
        }
    }
}



// 113
// 40
// 63
//
//          1                  2
//       ?+ Layla?             Shenhe
//    3 50           4 50
// yae miko     !yae miko
// ?Shenhe?       Shenhe
// System.out.println((60 * 17 + 4 * 60 + 60 * 9 + 50 + 20 + 40 + 40 + 40 + 40 + 40) / 160.0);
// return;
// 40
// System.out.println((60 * 5 + 60 * 5 + 30 * 5) + 420 + 420 + 160 * 5);
// System.out.println((60 * 2 * 30 + 300 * 2 * 2 + 3000 * 2) / 160.0);
// return;