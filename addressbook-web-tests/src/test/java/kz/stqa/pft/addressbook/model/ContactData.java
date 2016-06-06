package kz.stqa.pft.addressbook.model;

public class ContactData {
    private final String first_name;
    private final String second_name;
    private final String last_name;
    private final String company;
    private final String phone;
    private String group;

    public ContactData(String first_name, String second_name, String last_name, String company, String phone, String group) {
        this.first_name = first_name;
        this.second_name = second_name;
        this.last_name = last_name;
        this.company = company;
        this.phone = phone;
        this.group = group;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getSecond_name() {
        return second_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getCompany() {
        return company;
    }

    public String getPhone() {
        return phone;
    }

    public String getGroup() {
        return group;
    }
}
