public class Login {
    User logIn(String name) throws Exception {
        CRUDuser crud = new CRUDuser();
        User[] users = crud.Read();
        for (int i = 0; i < users.length; i++) {
            if(users[i].name.equals(name))
            {
                return users[i];
            }
        }
        throw new Exception("Nie ma takiego uzytkownika!");
    }

}
