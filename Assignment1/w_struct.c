#include <stdio.h>

typedef struct StuInfo {    // define struct
    char name[50];
    int age;
    float gpa;
    char gradeLevel[20];
} StuInfo;

int main(int argc, char const *argv[]) {
    StuInfo studentInfo[20];        // 20 students max
    fprintf(stderr, "Read n (max 20) students, and information seperated by spaces\n");
    int n;              // read amount
    scanf("%d", &n);
    for (int i = 0; i < n; i++) {
        scanf("%s %d %f %s", studentInfo[i].name, &studentInfo[i].age, 
                            &studentInfo[i].gpa, studentInfo[i].gradeLevel);    // read data
    }
    printf("Students:\n");
    for (int i = 0; i < n; i++) {
        printf("Student %d\n", i + 1);
        printf("Name: %s\nAge: %d\nGPA: %f\nGrade Level: %s\n", 
                studentInfo[i].name, studentInfo[i].age, studentInfo[i].gpa, 
                                            studentInfo[i].gradeLevel);         // print data
    }
    return 0;
}
