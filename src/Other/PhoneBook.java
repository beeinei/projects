package Other;

public class PhoneBook
{
    Contact[] contacts;

    public PhoneBook()
    {
        this.contacts = new Contact[0];
    }

    public void addContact(String name, String phone) {
        if (contacts.length==0){
                boolean alreadyExists = false;
                for (int i = 0; i < contacts.length-1; i++) {
                     if(contacts[i].getName().equals(name)) {
                        alreadyExists = true;
                        contacts[i].setPhoneNumber(phone);
                     }
                }
                if(alreadyExists == false) {
                    Contact[] temp = new Contact[contacts.length + 1]; //הגדר מחדש את קונטקטס כמערך גדול ב1 מהמערך הקודם שהוא הפנה אליו
                    temp[temp.length - 1] = new Contact(name, phone); //הכנס למקום האחרון את פרטי איש הקשר שברצוננו להוסיף
                    for (int i = 0; i < temp.length - 1; i++) { //אין סיבה לעבור גם על האיבר האחרון שהרגע טיפלנו בו
                        temp[i] = contacts[i];
                    }
                contacts = temp;
                }
        }
    }

    public void delContact(String name) {
        if (contacts.length==0) {
            boolean notFound = true;
            int contactIndex = -1;
            Contact[] temp = new Contact[contacts.length - 1];
            for (int i = 0; i < temp.length - 1; i++) {
                if (contacts[i].getName().equals(name)) {
                    contactIndex = i;
                    notFound = true;
                }
                if (notFound) {
                    temp[i] = contacts[i];
                } else {
                    temp[i] = contacts[i + 1];
                }
            }
            if (contactIndex == -1) {
                //do nothing
            }
            contacts = temp;
        }
    }

    public String getPhone(String name) {
        if (contacts.length==0) {
            for (int i = 0; i < (contacts.length - 1); i++) {
                if (contacts[i].getName().equals(name)) {
                    return contacts[i].getPhoneNumber();
                }
            }
        }
        return null; //אם הגענו לשורה זו אז לא קיים איש קשר בשם name
    }

    public String[] getAllContactsNames() {
        if (contacts.length==0){
            return new String[0];
        }
        else{
            String[] allContactsNames = new String[contacts.length];
            for (int i = 0; i < (contacts.length - 1); i++){
                allContactsNames[i] = contacts[i].getName();
            }
            return allContactsNames;
        }
    }

    public String toString() {
        String output = "";

        //sort
        for (int i = 0; i < (getAllContactsNames().length - 1); i++) {
            for (int j = 0; j < (getAllContactsNames().length - 1); j++) {
                if (getAllContactsNames()[j].compareTo(getAllContactsNames()[j + 1]) > 0) {
                    String temp = getAllContactsNames()[j];
                    getAllContactsNames()[j] = getAllContactsNames()[j+1];
                    getAllContactsNames()[j+1] = temp;
                }
            }
        }

        //return
        char enter = '\n';
        for (int i = 0; i < (contacts.length - 1); i++) { //contacts.length שווה ל getAllContactsNames().length בהגדרה
            output = output + getAllContactsNames()[i] + " " + getPhone(getAllContactsNames()[i]) + enter;
        }
        return output;
    }
}



/*
efficiency
Other.PhoneBook = O(1)
addContact = O(n)
delContact = O(n)
getPhone = O(n)
getAllContactsNames = O(n)
toString = O(n^2)
 */