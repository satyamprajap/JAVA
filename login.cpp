#include<iostream>
#include<fstream>
using namespace std;

class temp {
    string username, Email, password;
    fstream file;

public:
    void login();
    void signup();
    void forgot();
} obj;

int main() {
    char choice;
    do {
        cout << "\n1 - Login";
        cout << "\n2 - Sign Up";
        cout << "\n3 - Forgot Password";
        cout << "\n4 - Exit";
        cout << "\nEnter your choice :: ";
        cin >> choice;
        cin.ignore(); // clear newline buffer

        switch (choice) {
        case '1':
            obj.login();
            break;
        case '2':
            obj.signup();
            break;
        case '3':
            obj.forgot();
            break;
        case '4':
            return 0;
        default:
            cout << "Invalid selection....!" << endl;
        }
    } while (choice != '4');
}

void temp::signup() {
    cout << "\nEnter your user name :: ";
    getline(cin, username);
    cout << "Enter your Email address :: ";
    getline(cin, Email);
    cout << "Enter your password :: ";
    getline(cin, password);

    file.open("logindata.txt", ios::out | ios::app);
    file << username << "*" << Email << "*" << password << endl;
    file.close();

    cout << "Signup successful!\n";
}

void temp::login() {
    string searchname, searchpass;
    bool found = false;

    cout << "--------LOGIN---------\n";
    cout << "Enter your user name :: ";
    getline(cin, searchname);
    cout << "Enter your password :: ";
    getline(cin, searchpass);

    file.open("logindata.txt", ios::in);
    while (getline(file, username, '*')) {
        getline(file, Email, '*');
        getline(file, password);

        if (username == searchname && password == searchpass) {
            cout << "\nAccount login successful...!";
            cout << "\nUsername :: " << username << endl;
            cout << "Email :: " << Email << endl;
            found = true;
            break;
        }
    }
    file.close();

    if (!found)
        cout << "Invalid username or password.\n";
}

void temp::forgot() {
    string searchname, searchemail;
    bool found = false;

    cout << "\nEnter your username :: ";
    getline(cin, searchname);
    cout << "Enter your email address :: ";
    getline(cin, searchemail);

    file.open("logindata.txt", ios::in);
    while (getline(file, username, '*')) {
        getline(file, Email, '*');
        getline(file, password);

        if (username == searchname && Email == searchemail) {
            cout << "\nAccount found....!";
            cout << "\nYour password :: " << password << endl;
            found = true;
            break;
        }
    }
    file.close();

    if (!found)
        cout << "\nAccount not found.....!\n";
}

