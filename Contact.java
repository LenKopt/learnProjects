package com.epam.rd.contactbook;

public class Contact {

    private String contactName;
    private ContactInfo tel;
    private Email[] listEmail = new Email[3];
    private Social[] listLinks = new Social[5];

    public Contact(String contactName) {
        this.contactName = contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public void rename(String newName) {
        if (newName != null && newName != "") {
            setContactName(newName);
        }
    }

    public void setTel(ContactInfo tel) {
        this.tel = tel;
    }

    boolean addToArrayEmail(Email email) {
        for (int i = 0; i < listEmail.length; i++) {
            if (listEmail[i] == null) {
                listEmail[i] = email;
                return true;
            }
        }
        return false;
    }

    boolean addToArraySocial(Social link) {
        for (int i = 0; i < listLinks.length; i++) {
            if (listLinks[i] == null) {
                listLinks[i] = link;
                return true;
            }
        }
        return false;
    }

    public Email addEmail(String localPart, String domain) {
        Email email = new Email(localPart, domain);
        if (addToArrayEmail(email)) {
            return email;
        }
        return null;
    }


    public Email addEpamEmail(String firstname, String lastname) {

        Contact.Email email = new Contact.Email(firstname, lastname) {
            @Override
            public String getTitle() {
                return "Epam " + super.getTitle();
            }

            @Override
            public String getValue() {
                return firstname + "_" + lastname + "@epam.com";
            }
        };
        if (addToArrayEmail(email)) {
            return email;
        }
        return null;
    }

    public ContactInfo addPhoneNumber(int code, String number) {
        ContactInfo telNum = new ContactInfo() {
            @Override
            public String getTitle() {
                return "Tel";
            }

            @Override
            public String getValue() {
                return "+" + code + " " + number;
            }
        };
        if (tel == null) {
            setTel(telNum);
            return telNum;
        }
        return null;
    }

    public Social addTwitter(String twitterId) {
        Social twit = new Social("Twitter", twitterId);
        if (addToArraySocial(twit)) {
            return twit;
        }
        return null;
    }

    public Social addInstagram(String instagramId) {
        Social inst = new Social("Instagram", instagramId);
        if (addToArraySocial(inst)) {
            return inst;
        }
        return null;
    }

    public Social addSocialMedia(String title, String id) {
        Social other = new Social(title, id);
        if (addToArraySocial(other)) {
            return other;
        }
        return null;
    }

    public ContactInfo[] getInfo() {
        int sizeArray = 1;
        if (tel != null) {
            sizeArray++;
        }
        for (int i = 0; i < 5; i++) {
            if (listLinks[i] != null) {
                sizeArray++;
            }
            if (i > 2) {
                continue;
            }
            if (listEmail[i] != null) {
                sizeArray++;
            }
        }
        ContactInfo[] array = new ContactInfo[sizeArray];
        ContactInfo name = new NameContactInfo();
        array[0] = name;
        int j = 1;
        if (tel != null) {
            array[1] = tel;
            j++;
        }

        for (int i = 0; i < listEmail.length; i++) {
            if (listEmail[i] != null) {
                array[j] = listEmail[i];
                j++;
            }
        }
        for (int i = 0; i < listLinks.length; i++) {
            if (listLinks[i] != null) {
                array[j] = listLinks[i];
                j++;
            }
        }
        return array;
    }

    private class NameContactInfo implements ContactInfo {
        @Override
        public String getTitle() {
            return "Name";
        }

        @Override
        public String getValue() {
            return contactName;
        }

        @Override
        public String toString() {
            return getTitle() + getValue();
        }
    }

    public static class Social implements ContactInfo {
        private String title, id;

        public Social(String title, String id) {
            this.title = title;
            this.id = id;
        }

        @Override
        public String getTitle() {
            return title;
        }

        @Override
        public String getValue() {
            return id;
        }
    }

    public static class Email implements ContactInfo {

        private String localPart, domain;

        public Email(String localPart, String domain) {
            this.localPart = localPart;
            this.domain = domain;
        }

        @Override
        public String getTitle() {
            return "Email";
        }

        @Override
        public String getValue() {
            return localPart + "@" + domain;
        }
    }

}
