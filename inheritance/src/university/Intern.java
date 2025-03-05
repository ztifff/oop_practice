package university;

import company.OfficeBuilding;

public class Intern extends OfficeBuilding{
public Intern() {
System.out.println("Intern has been initialized..");
}

public void accessProjectFiles() {
System.out.println("Intern Viewing project files : " + projectFiles);
viewProjectFiles();
}
}
