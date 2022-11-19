public class StudentAttentionInfo {
    private final String name;
    private boolean isPresent;
    private int grade;

    public StudentAttentionInfo(String name) {
        this.name = name;
        this.isPresent = false;
        this.grade = 0;
    }

    public String getName() {
        return name;
    }

    public boolean isPresent() {
        return isPresent;
    }

    public void setPresent(boolean present) {
        isPresent = present;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Запись о студенте " + name +
                ": " + (isPresent ? "присутствовал(а), оценка: " + grade : "не присутствовал(а)");
    }
}
