import { AccountTypeDetail } from "./AccountTypeDetail";
import { TypeOfEmploymentDetail } from "./TypeOfEmploymentDetail";
import { UserDetail } from "./UserDetail";

export class EmploymentDetail{
    employeeId: number;
    annualSalary: number;
    accountTypeDetail: AccountTypeDetail;
    typeOfEmploymentDetail: TypeOfEmploymentDetail;
    userDetail: UserDetail;
}