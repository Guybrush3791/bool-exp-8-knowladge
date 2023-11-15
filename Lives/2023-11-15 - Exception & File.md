## Todo
### Eccezioni
Creare un programma che prenda in input il numero di utenti che si vuole inserire all'interno di un `arraylist`.
Fare poi un ciclo `while` che inserisca gli utenti (rappresentati da una classe `User`) all'interno della lista.
**Lanciare un'eccezione** se i dati delle persone **non sono corretti** (`username` vuoto o più breve di 3 caratteri, `password` più di 3 caratteri), in quel caso l'utente non viene inserito nella lista.

Stampare alla fine l'elenco degli utenti.

```java
public class User {

	private String username;
	private String password;
	
	public User(String username, String password) throws Exception {
		
		setUsername(username);
		setPassword(password);
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) throws Exception {
		
		if (username == null || username.isEmpty() || username.length() <= 3) 
			throw new Exception("username must be longer then 3 characters");
		
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) throws PasswordException {
		
		if (password == null || password.isEmpty() || password.length() <= 3)
			throw new PasswordException("password must be longer then 3 characters");
		
//		boolean finded = false;
//		for (int x=0;x<password.length();x++) {
//			
//			if (/*i-esimo carattere e' un numero*/)
//				finded = true;
//		}
//		
//		if (!finded) {
//			throw new PasswordException("password must be longer then 3 characters");
//		}
		
		this.password = password;
	}
	
	@Override
	public String toString() {
		
		return getUsername();
	}
}
```
### Files
Partendo dall'esercizio precedente, creare un file e scrivere alla fine nel file la lista delle persone inserite.
In seguito rileggere il file, elemento per elemento, e mostrare a video solo le persone con username che comincia per `g`.

```java
public class ExceptionFileEx {

	static final File mioFile = new File("/tmp/tmp/test.txt");
	
	public static void main(String[] args) {

		// EXCEPTION		
		Scanner in = new Scanner(System.in);
		
		System.out.print("User da creare: ");
		String strUserCount = in.nextLine();
		int userCount = Integer.valueOf(strUserCount);
		
		int userIndex = 0;
		User[] users = new User[userCount];
		while(userIndex < userCount) {
			
			System.out.println("Utente " + (userIndex + 1));
			System.out.print("Username: ");
			String username = in.nextLine();
			
			System.out.print("Password: ");
			String password = in.nextLine();
			
			User user = null;
			
			try {
				
				user = new User(username, password);
				
				users[userIndex++] = user;
			} catch (PasswordException e) {
				
				System.out.println("Error in password: " + e.getMessage());
			} catch (Exception e) {

				System.out.println("Errore in username: " + e.getMessage());
			}
		}
		
		System.out.println(Arrays.asList(users));

		// FILE
		// --WRITE
		FileWriter myWriter = null;
		
		try {
			
			myWriter = new FileWriter(mioFile);
			
			for (int x=0;x<users.length;x++) {
				
				User u = users[x];
				
				myWriter.write(u.getUsername() + "\n");
			}
		} catch (IOException e) {
			
			System.out.println("Error writing file: " + e.getMessage());
		} finally {
			
			if (myWriter != null)
				try {
					myWriter.close();
				} catch (IOException e) { }
		}	
		
		// --READ
		Scanner reader = null;
		try {
			
			reader = new Scanner(mioFile);
			
			while (reader.hasNextLine()) {
			   String data = reader.nextLine();
			   
			   if (data.toLowerCase().startsWith("g"))
				   System.out.println(data);
			}
		} catch (FileNotFoundException e) {
			
			System.out.println("Error reading file: " + e.getMessage());
		} finally {
			
			if (reader != null)
				reader.close();
		}
	}
}
```