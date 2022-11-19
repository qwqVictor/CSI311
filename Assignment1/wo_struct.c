#include <stdio.h>

int main(int argc, char const* argv[]) {
    char name[50][20];
    int age[20];
    float gpa[20];
    char gradeLevel[20][20];        // max 20 students
    fprintf(stderr, "Read n (max 20) students, and information seperated by spaces\n");
    int n;
    scanf("%d", &n);    // read amount
    for (int i = 0; i < n; i++) {
        scanf("%s %d %f %s", name[i], &age[i], &gpa[i], gradeLevel[i]); // read data
    }
    printf("Students:\n");
    for (int i = 0; i < n; i++) {
        printf("Student %d\n", i + 1);
        printf("Name: %s\nAge: %d\nGPA: %f\nGrade Level: %s\n", 
                name[i], age[i], gpa[i], gradeLevel[i]);        // print data
    }
    return 0;
}
