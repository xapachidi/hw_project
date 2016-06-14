package kz.stqa.pft.addressbook.model;

public class ContactData {
    private int id;
    private final String first_name;
    private final String second_name;
    private final String last_name;
    private final String company;
    private final String phone;
    private String group;

    public ContactData(int id, String first_name, String second_name, String last_name, String company, String phone, String group) {
        this.id = id;
        this.first_name = first_name;
        this.second_name = second_name;
        this.last_name = last_name;
        this.company = company;
        this.phone = phone;
        this.group = group;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ContactData that = (ContactData) o;

        if (first_name != null ? !first_name.equals(that.first_name) : that.first_name != null) return false;
        return last_name != null ? last_name.equals(that.last_name) : that.last_name == null;

    }

    @Override
    public int hashCode() {
        int result = first_name != null ? first_name.hashCode() : 0;
        result = 31 * result + (last_name != null ? last_name.hashCode() : 0);
        return result;
    }

    public ContactData(String first_name, String second_name, String last_name, String company, String phone, String group) {
        this.id = Integer.MAX_VALUE;
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

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "ContactData{" +
                "first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                '}';
    }

}
