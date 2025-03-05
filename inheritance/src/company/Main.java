package company;

import university.Intern;

public class Main {

public static void main(String[] args) {
// TODO Auto-generated method stub
OfficeBuilding obj = new OfficeBuilding();
obj.visitReception();
obj.viewProjectFiles();
obj.useO3iceLounge();
obj.accessCEOO3ice();

Intern objIntern = new Intern();
objIntern.accessProjectFiles();
}
}