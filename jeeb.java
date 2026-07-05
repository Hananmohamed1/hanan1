import java.util.Scanner;
import java.util.Date;
/**

*Hanan Hassan mohamud
*id c6240146

 * Mashruuca: JEEP Mobile Money System (Java Console Application)
 * Awoodaha: Itus Haraaga, Kaarka Hadalka, Biil Payment, U Wareejin Lacag,
 *           Salaam Bank, Maareynta, iyo English Bill Payment.
 * 
 * NOTE: Code-kan waxaa loo qaabeeyay si fudud (beginner-friendly) isagoo
 *       raacaya shuruudaha ah inaan la isticmaalin Arrays, Methods dheeraad ah,
 *       ama Classes kale. Wax walba waxay ku dhex jiraan main() method-ka.
 * 
 */
public class JEEP {
    public static void main(String[] args) {
        // Scanner u qaabilsan akhriye weyn oo ka qaata input-ka user-ka
        Scanner scanner = new Scanner(System.in);
        
        // --- XOGTA ACCOUNT-KA (SYSTEM STATE VARIABLES) ---
        double balance = 500.00;          // Haraaga Wallet-ka (Default: $500)
        double salaamBalance = 1000.00;    // Haraaga Salaam Bank (Default: $1000)
        String pin = "1234";              // PIN-ka default-ka ah ee macaamilka
        String phoneNumber = "0615123456"; // Number-ka diiwaan gashan
        boolean isEnglish = false;        // Luuqada (Default waa Somali)
        boolean running = true;           // Xaalada barnaamijka (haddii uu shaqaynayo)
        // --- BANNER-KA FURITAANKA BARNAAMIJKA ---
        System.out.println("*************************************************");
        System.out.println("*                                               *");
        System.out.println("*         JEEP MOBILE MONEY SYSTEM              *");
        System.out.println("*       Ku Soo Dhowaada Adeegeena Sleek         *");
        System.out.println("*                                               *");
        System.out.println("*************************************************");
        // Loop-ka weyn ee barnaamijka maamulaya
        while (running) {
            
            // --- 1. SOO BANDHIGIDDA MENU-GA UGU WEYN (MAIN MENU) ---
            if (!isEnglish) {
                System.out.println("\n============ MENU-GA UGU WEYN ============");
                System.out.println("  1. Itus Haraaga (Check Balance)");
                System.out.println("  2. Kaarka Hadalka (Airtime & Data)");
                System.out.println("  3. Bixi Biil (Pay Bill)");
                System.out.println("  4. U Wareeji Lacag (Transfer Money)");
                System.out.println("  5. Warbixin Kooban (Mini Statement)");
                System.out.println("  6. Salaam Bank");
                System.out.println("  7. Maareynta (Management)");
                System.out.println("  8. Bill Payment (English)");
                System.out.println("  9. Exit (Ka Bax)");
                System.out.println("==========================================");
                System.out.print("Dooro adeega aad rabto (1-9): ");
            } else {
                System.out.println("\n============ MAIN MENU ============");
                System.out.println("  1. Check Balance");
                System.out.println("  2. Airtime & Data");
                System.out.println("  3. Pay Bill");
                System.out.println("  4. Transfer Money");
                System.out.println("  5. Mini Statement");
                System.out.println("  6. Salaam Bank");
                System.out.println("  7. Management");
                System.out.println("  8. Bill Payment (English)");
                System.out.println("  9. Exit");
                System.out.println("===================================");
                System.out.print("Select the service (1-9): ");
            }
            // Hubinta in user-ku uu galiyay lambar sax ah
            if (!scanner.hasNextInt()) {
                System.out.println(isEnglish ? "\n[✘] Invalid input! Please enter a number from 1 to 9." 
                                             : "\n[✘] Gelin khaldan! Fadlan geli lambar u dhexeeya 1 iyo 9.");
                scanner.nextLine(); // buffer clear-gareyso
                continue;
            }
            
            int choice = scanner.nextInt();
            scanner.nextLine(); // Waxaa loo baahan yahay in buffer-ka la clear-gareeyo si aysan nextLine() u boodin mar dambe
            // --- 2. MAAREYNTA MENU-YADA (SWITCH CASE ON CHOICE) ---
            switch (choice) {
                
                case 1: {
                    // --- CASE 1: ITUS HARAAGA / CHECK BALANCE ---
                    System.out.print(isEnglish ? "Enter your PIN: " : "Geli PIN-kaaga: ");
                    String enteredPin1 = scanner.nextLine();
                    System.out.print(isEnglish ? "Repeat PIN to confirm: " : "Ku celi PIN-kaaga si aad u xaqiijiso: ");
                    String enteredPin2 = scanner.nextLine();
                    
                    if (enteredPin1.equals(enteredPin2)) {
                        if (enteredPin1.equals(pin)) {
                            System.out.println("\n------------------------------------------");
                            if (!isEnglish) {
                                System.out.printf("[✔] Haraaga account-kaaga hadda waa: $%.2f\n", balance);
                            } else {
                                System.out.printf("[✔] Your current account balance is: $%.2f\n", balance);
                            }
                            System.out.println("------------------------------------------");
                        } else {
                            System.out.println(isEnglish ? "\n[✘] Incorrect PIN!" : "\n[✘] PIN waa khaldan yahay.");
                        }
                    } else {
                        System.out.println(isEnglish ? "\n[✘] PINs do not match! Access Denied." 
                                                     : "\n[✘] PIN-yadu isma laha! Masiirihii waa la joojiyay.");
                    }
                    break;
                }
                case 2: {
                    // --- CASE 2: KAARKA HADALKA / AIRTIME & DATA (NESTED MENU) ---
                    boolean subRunning = true;
                    while (subRunning) {
                        if (!isEnglish) {
                            System.out.println("\n--- ADEEGA KAARKA HADALKA (AIRTIME & DATA) ---");
                            System.out.println("  1. Ku Shubo Airtime Naftaada");
                            System.out.println("  2. Ku Shubo Airtime Qof Kale");
                            System.out.println("  3. Ku Iibso Data");
                            System.out.println("  4. Ka bixi (Go Back)");
                            System.out.println("----------------------------------------------");
                            System.out.print("Dooro adeega (1-4): ");
                        } else {
                            System.out.println("\n--- AIRTIME & DATA SERVICES ---");
                            System.out.println("  1. Recharge Airtime for Yourself");
                            System.out.println("  2. Recharge Airtime for Someone Else");
                            System.out.println("  3. Buy Data Bundles");
                            System.out.println("  4. Go Back");
                            System.out.println("----------------------------------------");
                            System.out.print("Select option (1-4): ");
                        }
                        if (!scanner.hasNextInt()) {
                            System.out.println(isEnglish ? "\n[✘] Invalid option!" : "\n[✘] Dooro khaldan!");
                            scanner.nextLine();
                            continue;
                        }
                        
                        int subChoice = scanner.nextInt();
                        scanner.nextLine(); // Clear scanner buffer
                        if (subChoice == 1) {
                            // Airtime for self
                            System.out.print(isEnglish ? "Enter Airtime Amount: $" : "Geli Lacagta Airtime-ka: $");
                            double amount = scanner.nextDouble();
                            scanner.nextLine(); // Clear buffer
                            
                            if (amount <= 0) {
                                System.out.println(isEnglish ? "\n[✘] Invalid amount!" : "\n[✘] Lacag khaldan!");
                                continue;
                            }
                            if (amount > balance) {
                                System.out.println(isEnglish ? "\n[✘] Insufficient balance!" : "\n[✘] Haraagaagu kuma filna.");
                                continue;
                            }
                            
                            System.out.print(isEnglish ? "Enter PIN: " : "Geli PIN: ");
                            String enteredPin1 = scanner.nextLine();
                            System.out.print(isEnglish ? "Repeat PIN to confirm: " : "Ku celi PIN si aad u xaqiijiso: ");
                            String enteredPin2 = scanner.nextLine();
                            
                            if (enteredPin1.equals(enteredPin2)) {
                                if (enteredPin1.equals(pin)) {
                                    balance -= amount;
                                    System.out.println("\n------------------------------------------");
                                    if (!isEnglish) {
                                        System.out.printf("[✔] Waad ku guuleysatay! Waxaad $%.2f ku shubatay telefoonkaaga.\nHaraagaaga cusub waa: $%.2f\n", amount, balance);
                                    } else {
                                        System.out.printf("[✔] Recharge successful! You loaded $%.2f airtime for yourself.\nNew Balance: $%.2f\n", amount, balance);
                                    }
                                    System.out.println("------------------------------------------");
                                } else {
                                    System.out.println(isEnglish ? "\n[✘] Incorrect PIN!" : "\n[✘] PIN waa khaldan yahay.");
                                }
                            } else {
                                System.out.println(isEnglish ? "\n[✘] PINs do not match!" : "\n[✘] PIN-yadu isma laha!");
                            }
                            
                        } else if (subChoice == 2) {
                            // Airtime for someone else
                            System.out.print(isEnglish ? "Enter receiver's phone number: " : "Geli number-ka telefoonka ee loo shubayo: ");
                            String targetNumber = scanner.nextLine();
                            
                            System.out.print(isEnglish ? "Enter Airtime Amount: $" : "Geli Lacagta Airtime-ka: $");
                            double amount = scanner.nextDouble();
                            scanner.nextLine(); // Clear buffer
                            
                            if (amount <= 0) {
                                System.out.println(isEnglish ? "\n[✘] Invalid amount!" : "\n[✘] Lacag khaldan!");
                                continue;
                            }
                            if (amount > balance) {
                                System.out.println(isEnglish ? "\n[✘] Insufficient balance!" : "\n[✘] Haraagaagu kuma filna.");
                                continue;
                            }
                            
                            System.out.print(isEnglish ? "Enter PIN: " : "Geli PIN: ");
                            String enteredPin1 = scanner.nextLine();
                            System.out.print(isEnglish ? "Repeat PIN to confirm: " : "Ku celi PIN si aad u xaqiijiso: ");
                            String enteredPin2 = scanner.nextLine();
                            
                            if (enteredPin1.equals(enteredPin2)) {
                                if (enteredPin1.equals(pin)) {
                                    balance -= amount;
                                    System.out.println("\n------------------------------------------");
                                    if (!isEnglish) {
                                        System.out.printf("[✔] Waad ku guuleysatay! Waxaad $%.2f airtime ah u dirtay lambarka %s.\nHaraagaaga hadda waa: $%.2f\n", amount, targetNumber, balance);
                                    } else {
                                        System.out.printf("[✔] Success! You sent $%.2f airtime to %s.\nYour remaining balance is: $%.2f\n", amount, targetNumber, balance);
                                    }
                                    System.out.println("------------------------------------------");
                                } else {
                                    System.out.println(isEnglish ? "\n[✘] Incorrect PIN!" : "\n[✘] PIN waa khaldan yahay.");
                                }
                            } else {
                                System.out.println(isEnglish ? "\n[✘] PINs do not match!" : "\n[✘] PIN-yadu isma laha!");
                            }
                            
                        } else if (subChoice == 3) {
                            // Buy Data Bundles
                            if (!isEnglish) {
                                System.out.println("\n--- XIRMOOYINKA DATA-DA (DATA BUNDLES) ---");
                                System.out.println("  1. Xirmo Maalinle ($1.00 = 2GB)");
                                System.out.println("  2. Xirmo Todobaadle ($2.00 = 5GB)");
                                System.out.println("  3. Xirmo Bishaar ($5.00 = 15GB)");
                                System.out.println("------------------------------------------");
                                System.out.print("Dooro xirmo (1-3): ");
                            } else {
                                System.out.println("\n--- DATA BUNDLES SELECTION ---");
                                System.out.println("  1. Daily Pack ($1.00 = 2GB)");
                                System.out.println("  2. Weekly Pack ($2.00 = 5GB)");
                                System.out.println("  3. Monthly Pack ($5.00 = 15GB)");
                                System.out.println("------------------------------------------");
                                System.out.print("Select bundle (1-3): ");
                            }
                            
                            if (!scanner.hasNextInt()) {
                                System.out.println(isEnglish ? "\n[✘] Invalid bundle!" : "\n[✘] Xirmo khaldan!");
                                scanner.nextLine();
                                continue;
                            }
                            int dataChoice = scanner.nextInt();
                            scanner.nextLine(); // Clear buffer
                            
                            double dataCost = 0;
                            String dataVolume = "";
                            
                            if (dataChoice == 1) {
                                dataCost = 1.00;
                                dataVolume = "2GB (Daily)";
                            } else if (dataChoice == 2) {
                                dataCost = 2.00;
                                dataVolume = "5GB (Weekly)";
                            } else if (dataChoice == 3) {
                                dataCost = 5.00;
                                dataVolume = "15GB (Monthly)";
                            } else {
                                System.out.println(isEnglish ? "\n[✘] Invalid option!" : "\n[✘] Dooro khaldan!");
                                continue;
                            }
                            
                            if (dataCost > balance) {
                                System.out.println(isEnglish ? "\n[✘] Insufficient balance!" : "\n[✘] Haraagaagu kuma filna.");
                                continue;
                            }
                            
                            System.out.print(isEnglish ? "Enter PIN: " : "Geli PIN: ");
                            String enteredPin1 = scanner.nextLine();
                            System.out.print(isEnglish ? "Repeat PIN to confirm: " : "Ku celi PIN si aad u xaqiijiso: ");
                            String enteredPin2 = scanner.nextLine();
                            
                            if (enteredPin1.equals(enteredPin2)) {
                                if (enteredPin1.equals(pin)) {
                                    balance -= dataCost;
                                    System.out.println("\n------------------------------------------");
                                    if (!isEnglish) {
                                        System.out.printf("[✔] Waad ku guuleysatay! Waxaad iibsatay xirmo data ah oo ah %s.\nHaraagaaga cusub waa: $%.2f\n", dataVolume, balance);
                                    } else {
                                        System.out.printf("[✔] Success! You bought a %s data pack.\nNew Balance: $%.2f\n", dataVolume, balance);
                                    }
                                    System.out.println("------------------------------------------");
                                } else {
                                    System.out.println(isEnglish ? "\n[✘] Incorrect PIN!" : "\n[✘] PIN waa khaldan yahay.");
                                }
                            } else {
                                System.out.println(isEnglish ? "\n[✘] PINs do not match!" : "\n[✘] PIN-yadu isma laha!");
                            }
                            
                        } else if (subChoice == 4) {
                            subRunning = false;
                        } else {
                            System.out.println(isEnglish ? "\n[✘] Invalid choice!" : "\n[✘] Dooro khaldan!");
                        }
                    }
                    break;
                }
                case 3: {
                    // --- CASE 3: BIXI BIIL / PAY BILL (SOMALI MENU) ---
                    boolean billRunning = true;
                    while (billRunning) {
                        System.out.println("\n--- ADEEGA BIXINTA BIILASHA ---");
                        System.out.println("  1. Bixi Koronto (Electricity)");
                        System.out.println("  2. Bixi Biyo (Water)");
                        System.out.println("  3. Bixi Internet");
                        System.out.println("  4. Ka bixi (Go Back)");
                        System.out.println("--------------------------------");
                        System.out.print("Dooro biilka (1-4): ");
                        
                        if (!scanner.hasNextInt()) {
                            System.out.println("\n[✘] Gelin khaldan!");
                            scanner.nextLine();
                            continue;
                        }
                        
                        int billChoice = scanner.nextInt();
                        scanner.nextLine(); // Clear buffer
                        
                        if (billChoice == 4) {
                            billRunning = false;
                            break;
                        }
                        
                        String billType = "";
                        if (billChoice == 1) {
                            billType = "Koronto (Electricity)";
                        } else if (billChoice == 2) {
                            billType = "Biyo (Water)";
                        } else if (billChoice == 3) {
                            billType = "Internet";
                        } else {
                            System.out.println("\n[✘] Dooro khaldan!");
                            continue;
                        }
                        
                        System.out.print("Geli Account Number-ka Biilka: ");
                        String accNum = scanner.nextLine();
                        
                        System.out.print("Geli Cadadka Lacagta: $");
                        double amount = scanner.nextDouble();
                        scanner.nextLine(); // Clear buffer
                        
                        if (amount <= 0) {
                            System.out.println("\n[✘] Lacag khaldan!");
                            continue;
                        }
                        if (amount > balance) {
                            System.out.println("\n[✘] Haraagaagu kuma filna.");
                            continue;
                        }
                        
                        System.out.print("Geli PIN si aad u xaqiijiso: ");
                        String enteredPin1 = scanner.nextLine();
                        System.out.print("Ku celi PIN-ka si aad u xaqiijiso: ");
                        String enteredPin2 = scanner.nextLine();
                        
                        if (enteredPin1.equals(enteredPin2)) {
                            if (enteredPin1.equals(pin)) {
                                balance -= amount;
                                System.out.println("\n------------------------------------------");
                                System.out.printf("[✔] Biil bixintu waxay u dhacday si guul leh!\n" +
                                                  "Waxaad $%.2f u bixisay adeega %s.\n" +
                                                  "Koontada qaataha: %s\nHaraagaaga cusub: $%.2f\n", 
                                                  amount, billType, accNum, balance);
                                System.out.println("------------------------------------------");
                            } else {
                                System.out.println("\n[✘] PIN waa khaldan yahay. Biil bixintu way fashilantay!");
                            }
                        } else {
                            System.out.println("\n[✘] PIN-yadu isma laha. Biil bixintu way fashilantay!");
                        }
                    }
                    break;
                }
                case 4: {
                    // --- CASE 4: U WAREEJI LACAG / TRANSFER MONEY ---
                    boolean transRunning = true;
                    while (transRunning) {
                        if (!isEnglish) {
                            System.out.println("\n--- ADEEGA WAREEJINTA LACAGTA ---");
                            System.out.println("  1. Zaad Services");
                            System.out.println("  2. Sahal Services");
                            System.out.println("  3. EVC Plus");
                            System.out.println("  4. Salaam Bank");
                            System.out.println("  5. Ka bixi (Go Back)");
                            System.out.println("---------------------------------");
                            System.out.print("Dooro meesha aad u wareejinayso (1-5): ");
                        } else {
                            System.out.println("\n--- TRANSFER MONEY OPTIONS ---");
                            System.out.println("  1. Zaad Services");
                            System.out.println("  2. Sahal Services");
                            System.out.println("  3. EVC Plus");
                            System.out.println("  4. Salaam Bank");
                            System.out.println("  5. Go Back");
                            System.out.println("------------------------------");
                            System.out.print("Select platform (1-5): ");
                        }
                        if (!scanner.hasNextInt()) {
                            System.out.println(isEnglish ? "\n[✘] Invalid option!" : "\n[✘] Dooro khaldan!");
                            scanner.nextLine();
                            continue;
                        }
                        
                        int transChoice = scanner.nextInt();
                        scanner.nextLine(); // Clear buffer
                        
                        if (transChoice == 5) {
                            transRunning = false;
                            break;
                        }
                        
                        String platform = "";
                        if (transChoice == 1) platform = "Zaad";
                        else if (transChoice == 2) platform = "Sahal";
                        else if (transChoice == 3) platform = "EVC Plus";
                        else if (transChoice == 4) platform = "Salaam Bank";
                        else {
                            System.out.println(isEnglish ? "\n[✘] Invalid choice!" : "\n[✘] Dooro khaldan!");
                            continue;
                        }
                        
                        System.out.print(isEnglish ? "Enter receiver number/account: " : "Geli number-ka ama account-ka qaataha: ");
                        String targetAcc = scanner.nextLine();
                        
                        System.out.print(isEnglish ? "Enter Amount to send: $" : "Geli lacagta aad u wareejinayso: $");
                        double amount = scanner.nextDouble();
                        scanner.nextLine(); // Clear buffer
                        
                        if (amount <= 0) {
                            System.out.println(isEnglish ? "\n[✘] Invalid amount!" : "\n[✘] Lacag khaldan!");
                            continue;
                        }
                        if (amount > balance) {
                            System.out.println(isEnglish ? "\n[✘] Insufficient balance!" : "\n[✘] Haraagaagu kuma filna.");
                            continue;
                        }
                        
                        System.out.print(isEnglish ? "Enter PIN: " : "Geli PIN: ");
                        String enteredPin1 = scanner.nextLine();
                        System.out.print(isEnglish ? "Confirm PIN (Repeat): " : "Ku celi PIN-ka (Xaqiiji): ");
                        String enteredPin2 = scanner.nextLine();
                        
                        if (enteredPin1.equals(enteredPin2)) {
                            if (enteredPin1.equals(pin)) {
                                balance -= amount;
                                System.out.println("\n------------------------------------------");
                                if (!isEnglish) {
                                    System.out.printf("[✔] Wareejintu way guuleysatay!\n" +
                                                      "Waxaad $%.2f u dirtay lambarka %s adigoo isticmaalaya (%s).\n" +
                                                      "Haraagaaga cusub: $%.2f\n", amount, targetAcc, platform, balance);
                                } else {
                                    System.out.printf("[✔] Transfer successful!\n" +
                                                      "You transferred $%.2f to %s via (%s).\n" +
                                                      "New wallet balance is: $%.2f\n", amount, targetAcc, platform, balance);
                                }
                                System.out.println("------------------------------------------");
                            } else {
                                System.out.println(isEnglish ? "\n[✘] Incorrect PIN! Transfer cancelled." 
                                                             : "\n[✘] PIN waa khaldan yahay! Macaamilka waa la baajiyay.");
                            }
                        } else {
                            System.out.println(isEnglish ? "\n[✘] PINs do not match! Transfer cancelled." 
                                                         : "\n[✘] PIN-yadu isma laha! Macaamilka waa la baajiyay.");
                        }
                    }
                    break;
                }
                case 5: {
                    // --- CASE 5: WARBIXIN KOOBAN / MINI STATEMENT ---
                    System.out.println("\n=======================================================");
                    if (!isEnglish) {
                        System.out.println("              WARBIXIN KOOBAN (MINI STATEMENT)       ");
                        System.out.println("  Waqtiga Maanta  : " + new Date().toString());
                        System.out.printf("  Haraaga Wallet-ka: $%.2f\n", balance);
                        System.out.println("-------------------------------------------------------");
                        System.out.println("  Taariikh     | Nooca Macaamilka        | Cadadka ");
                        System.out.println("-------------------------------------------------------");
                        System.out.println("  2026-07-04   | Deposit Salaam Bank     | +$200.00");
                        System.out.println("  2026-07-03   | Koronto Biil Payment    | -$45.00 ");
                        System.out.println("  2026-07-03   | Airtime Shubasho (Self) | -$10.00 ");
                        System.out.println("  2026-07-02   | EVC Plus (0615999999)   | -$150.00");
                        System.out.println("  2026-07-01   | Lacag dhigid (Direct)   | +$500.00");
                    } else {
                        System.out.println("                  MINI STATEMENT                       ");
                        System.out.println("  Current Date : " + new Date().toString());
                        System.out.printf("  Wallet Balance: $%.2f\n", balance);
                        System.out.println("-------------------------------------------------------");
                        System.out.println("  Date         | Transaction Type        | Amount  ");
                        System.out.println("-------------------------------------------------------");
                        System.out.println("  2026-07-04   | Salaam Bank Withdrawal  | +$200.00");
                        System.out.println("  2026-07-03   | Electricity Bill Paid   | -$45.00 ");
                        System.out.println("  2026-07-03   | Airtime Self Recharge   | -$10.00 ");
                        System.out.println("  2026-07-02   | EVC Plus Transfer       | -$150.00");
                        System.out.println("  2026-07-01   | Direct Cash Deposit     | +$500.00");
                    }
                    System.out.println("=======================================================");
                    break;
                }
                case 6: {
                    // --- CASE 6: SALAAM BANK (NESTED MENU) ---
                    boolean salaamRunning = true;
                    while (salaamRunning) {
                        if (!isEnglish) {
                            System.out.println("\n--- ADEEGYADA SALAAM BANK ---");
                            System.out.println("  1. Hubi Balance-ka Banka");
                            System.out.println("  2. Lacag dhig (Deposit: Wallet -> Bank)");
                            System.out.println("  3. Lacag qaado (Withdraw: Bank -> Wallet)");
                            System.out.println("  4. U wareeji Account kale (Bank to Bank)");
                            System.out.println("  5. Ka bixi (Go Back)");
                            System.out.println("------------------------------");
                            System.out.print("Dooro adeega Salaam Bank (1-5): ");
                        } else {
                            System.out.println("\n--- SALAAM BANK SERVICES ---");
                            System.out.println("  1. Check Bank Balance");
                            System.out.println("  2. Deposit Funds (Wallet -> Bank)");
                            System.out.println("  3. Withdraw Funds (Bank -> Wallet)");
                            System.out.println("  4. Transfer to Another Salaam Account");
                            System.out.println("  5. Go Back");
                            System.out.println("----------------------------");
                            System.out.print("Select bank action (1-5): ");
                        }
                        if (!scanner.hasNextInt()) {
                            System.out.println(isEnglish ? "\n[✘] Invalid choice!" : "\n[✘] Dooro khaldan!");
                            scanner.nextLine();
                            continue;
                        }
                        
                        int salaamChoice = scanner.nextInt();
                        scanner.nextLine(); // Clear buffer
                        
                        if (salaamChoice == 5) {
                            salaamRunning = false;
                            break;
                        }
                        if (salaamChoice == 1) {
                            // Check Bank Balance
                            System.out.print(isEnglish ? "Enter PIN: " : "Geli PIN: ");
                            String enteredPin1 = scanner.nextLine();
                            System.out.print(isEnglish ? "Confirm PIN (Repeat): " : "Ku celi PIN-ka (Xaqiiji): ");
                            String enteredPin2 = scanner.nextLine();
                            
                            if (enteredPin1.equals(enteredPin2)) {
                                if (enteredPin1.equals(pin)) {
                                    System.out.println("\n------------------------------------------");
                                    if (!isEnglish) {
                                        System.out.printf("[✔] Haraagaaga Salaam Bank waa: $%.2f\n", salaamBalance);
                                    } else {
                                        System.out.printf("[✔] Your Salaam Bank balance is: $%.2f\n", salaamBalance);
                                    }
                                    System.out.println("------------------------------------------");
                                } else {
                                    System.out.println(isEnglish ? "\n[✘] Incorrect PIN!" : "\n[✘] PIN waa khaldan yahay.");
                                }
                            } else {
                                System.out.println(isEnglish ? "\n[✘] PINs do not match!" : "\n[✘] PIN-yadu isma laha.");
                            }
                            
                        } else if (salaamChoice == 2) {
                            // Deposit: Wallet to Bank
                            System.out.print(isEnglish ? "Enter deposit amount: $" : "Geli lacagta aad dhiganayso: $");
                            double amount = scanner.nextDouble();
                            scanner.nextLine(); // Clear buffer
                            
                            if (amount <= 0) {
                                System.out.println(isEnglish ? "\n[✘] Invalid amount!" : "\n[✘] Lacag khaldan!");
                                continue;
                            }
                            if (amount > balance) {
                                System.out.println(isEnglish ? "\n[✘] Insufficient wallet balance!" 
                                                             : "\n[✘] Haraagaaga Wallet-ka kuguma filna.");
                                continue;
                            }
                            
                            System.out.print(isEnglish ? "Enter PIN: " : "Geli PIN: ");
                            String enteredPin1 = scanner.nextLine();
                            System.out.print(isEnglish ? "Confirm PIN (Repeat): " : "Ku celi PIN-ka (Xaqiiji): ");
                            String enteredPin2 = scanner.nextLine();
                            
                            if (enteredPin1.equals(enteredPin2)) {
                                if (enteredPin1.equals(pin)) {
                                    balance -= amount;
                                    salaamBalance += amount;
                                    System.out.println("\n------------------------------------------");
                                    if (!isEnglish) {
                                        System.out.printf("[✔] Waxaad $%.2f ku wareejisay Salaam Bank.\nHaraaga Wallet-ka: $%.2f | Salaam Bank: $%.2f\n", 
                                                          amount, balance, salaamBalance);
                                    } else {
                                        System.out.printf("[✔] Success! Deposited $%.2f to Salaam Bank.\nWallet Balance: $%.2f | Salaam Bank: $%.2f\n", 
                                                          amount, balance, salaamBalance);
                                    }
                                    System.out.println("------------------------------------------");
                                } else {
                                    System.out.println(isEnglish ? "\n[✘] Incorrect PIN!" : "\n[✘] PIN waa khaldan yahay.");
                                }
                            } else {
                                System.out.println(isEnglish ? "\n[✘] PINs do not match!" : "\n[✘] PIN-yadu isma laha.");
                            }
                            
                        } else if (salaamChoice == 3) {
                            // Withdraw: Bank to Wallet
                            System.out.print(isEnglish ? "Enter withdrawal amount: $" : "Geli lacagta aad soo qaadanayso: $");
                            double amount = scanner.nextDouble();
                            scanner.nextLine(); // Clear buffer
                            
                            if (amount <= 0) {
                                System.out.println(isEnglish ? "\n[✘] Invalid amount!" : "\n[✘] Lacag khaldan!");
                                continue;
                            }
                            if (amount > salaamBalance) {
                                System.out.println(isEnglish ? "\n[✘] Insufficient bank balance!" 
                                                             : "\n[✘] Haraaga Salaam Bank kuguma filna.");
                                continue;
                            }
                            
                            System.out.print(isEnglish ? "Enter PIN: " : "Geli PIN: ");
                            String enteredPin1 = scanner.nextLine();
                            System.out.print(isEnglish ? "Confirm PIN (Repeat): " : "Ku celi PIN-ka (Xaqiiji): ");
                            String enteredPin2 = scanner.nextLine();
                            
                            if (enteredPin1.equals(enteredPin2)) {
                                if (enteredPin1.equals(pin)) {
                                    salaamBalance -= amount;
                                    balance += amount;
                                    System.out.println("\n------------------------------------------");
                                    if (!isEnglish) {
                                        System.out.printf("[✔] Waxaad $%.2f kala soo baxday Salaam Bank.\nHaraaga Wallet-ka: $%.2f | Salaam Bank: $%.2f\n", 
                                                      amount, balance, salaamBalance);
                                    } else {
                                        System.out.printf("[✔] Success! Withdrew $%.2f from Salaam Bank.\nWallet Balance: $%.2f | Salaam Bank: $%.2f\n", 
                                                      amount, balance, salaamBalance);
                                    }
                                    System.out.println("------------------------------------------");
                                } else {
                                    System.out.println(isEnglish ? "\n[✘] Incorrect PIN!" : "\n[✘] PIN waa khaldan yahay.");
                                }
                            } else {
                                System.out.println(isEnglish ? "\n[✘] PINs do not match!" : "\n[✘] PIN-yadu isma laha.");
                            }
                            
                        } else if (salaamChoice == 4) {
                            // Bank to Bank Transfer
                            System.out.print(isEnglish ? "Enter destination Salaam Bank Account: " 
                                                       : "Geli account-ka kale ee Salaam Bank: ");
                            String targetAcc = scanner.nextLine();
                            
                            System.out.print(isEnglish ? "Enter transfer amount: $" : "Geli lacagta: $");
                            double amount = scanner.nextDouble();
                            scanner.nextLine(); // Clear buffer
                            
                            if (amount <= 0) {
                                System.out.println(isEnglish ? "\n[✘] Invalid amount!" : "\n[✘] Lacag khaldan!");
                                continue;
                            }
                            if (amount > salaamBalance) {
                                System.out.println(isEnglish ? "\n[✘] Insufficient bank balance!" 
                                                             : "\n[✘] Haraaga Salaam Bank kuguma filna.");
                                continue;
                            }
                            
                            System.out.print(isEnglish ? "Enter PIN: " : "Geli PIN: ");
                            String enteredPin1 = scanner.nextLine();
                            System.out.print(isEnglish ? "Confirm PIN (Repeat): " : "Ku celi PIN-ka (Xaqiiji): ");
                            String enteredPin2 = scanner.nextLine();
                            
                            if (enteredPin1.equals(enteredPin2)) {
                                if (enteredPin1.equals(pin)) {
                                    salaamBalance -= amount;
                                    System.out.println("\n------------------------------------------");
                                    if (!isEnglish) {
                                        System.out.printf("[✔] Waad ku guuleysatay inaad $%.2f u wareejiso Salaam Bank account %s.\nHaraagaaga banka: $%.2f\n", 
                                                      amount, targetAcc, salaamBalance);
                                    } else {
                                        System.out.printf("[✔] Successfully transferred $%.2f to Salaam Account %s.\nNew Bank Balance: $%.2f\n", 
                                                      amount, targetAcc, salaamBalance);
                                    }
                                    System.out.println("------------------------------------------");
                                } else {
                                    System.out.println(isEnglish ? "\n[✘] Incorrect PIN!" : "\n[✘] PIN waa khaldan yahay.");
                                }
                            } else {
                                System.out.println(isEnglish ? "\n[✘] PINs do not match!" : "\n[✘] PIN-yadu isma laha.");
                            }
                        } else {
                            System.out.println(isEnglish ? "\n[✘] Invalid choice!" : "\n[✘] Dooro khaldan!");
                        }
                    }
                    break;
                }
                case 7: {
                    // --- CASE 7: MAAREYNTA / MANAGEMENT (NESTED MENU) ---
                    boolean adminRunning = true;
                    while (adminRunning) {
                        if (!isEnglish) {
                            System.out.println("\n--- QEYBTA MAAREYNTA (MANAGEMENT) ---");
                            System.out.println("  1. Beddel PIN-ka");
                            System.out.println("  2. Beddel Language (Luuqadda)");
                            System.out.println("  3. Hubi Lambarkaaga");
                            System.out.println("  4. Xir Account-ka");
                            System.out.println("  5. Ka bixi (Go Back)");
                            System.out.println("-------------------------------------");
                            System.out.print("Dooro adeeg (1-5): ");
                        } else {
                            System.out.println("\n--- MANAGEMENT SYSTEM ---");
                            System.out.println("  1. Change PIN");
                            System.out.println("  2. Change Language");
                            System.out.println("  3. Check Your Phone Number");
                            System.out.println("  4. Close Account");
                            System.out.println("  5. Go Back");
                            System.out.println("-------------------------");
                            System.out.print("Select choice (1-5): ");
                        }
                        if (!scanner.hasNextInt()) {
                            System.out.println(isEnglish ? "\n[✘] Invalid choice!" : "\n[✘] Dooro khaldan!");
                            scanner.nextLine();
                            continue;
                        }
                        int adminChoice = scanner.nextInt();
                        scanner.nextLine(); // Clear buffer
                        
                        if (adminChoice == 5) {
                            adminRunning = false;
                            break;
                        }
                        
                        if (adminChoice == 1) {
                            // Change PIN
                            System.out.print(isEnglish ? "Enter Current PIN: " : "Geli PIN-ka hadda: ");
                            String currentPin = scanner.nextLine();
                            
                            if (currentPin.equals(pin)) {
                                System.out.print(isEnglish ? "Enter New 4-digit PIN: " : "Geli PIN-ka cusub oo ka kooban 4 digit: ");
                                String newPin1 = scanner.nextLine();
                                System.out.print(isEnglish ? "Confirm New PIN: " : "Xaqiiji PIN-ka cusub: ");
                                String newPin2 = scanner.nextLine();
                                
                                if (newPin1.equals(newPin2)) {
                                    pin = newPin1;
                                    System.out.println(isEnglish ? "\n[✔] PIN changed successfully!" 
                                                                 : "\n[✔] Waad ku guuleysatay! PIN-ka si fiican ayaa loo beddelay.");
                                } else {
                                    System.out.println(isEnglish ? "\n[✘] New PINs do not match!" 
                                                                 : "\n[✘] Labada PIN ee cusub isma laha!");
                                }
                            } else {
                                System.out.println(isEnglish ? "\n[✘] Incorrect Current PIN!" : "\n[✘] PIN-ka hadda waa khaldan yahay.");
                            }
                            
                        } else if (adminChoice == 2) {
                            // Change Language
                            System.out.println("\nSelect Language / Dooro Luuqadda:");
                            System.out.println("  1. Somali");
                            System.out.println("  2. English");
                            System.out.print("Dooro (1-2): ");
                            
                            int langChoice = scanner.nextInt();
                            scanner.nextLine(); // Clear buffer
                            
                            if (langChoice == 1) {
                                isEnglish = false;
                                System.out.println("\n[✔] Luuqadda hadda waa Somali.");
                            } else if (langChoice == 2) {
                                isEnglish = true;
                                System.out.println("\n[✔] Language set to English.");
                            } else {
                                System.out.println(isEnglish ? "\n[✘] Invalid choice!" : "\n[✘] Dooro khaldan!");
                            }
                            
                        } else if (adminChoice == 3) {
                            // Check Number
                            System.out.println("\n------------------------------------------");
                            if (!isEnglish) {
                                System.out.println("[✔] Lambarkaaga diiwaangashan waa: " + phoneNumber);
                            } else {
                                System.out.println("[✔] Your registered phone number is: " + phoneNumber);
                            }
                            System.out.println("------------------------------------------");
                            
                        } else if (adminChoice == 4) {
                            // Close Account
                            System.out.print(isEnglish ? "Are you sure you want to CLOSE your account? (Yes/No): " 
                                                       : "Ma hubtaa inaad rabto inaad XIRTO account-kaaga? (Haa/Maya): ");
                            String confirm = scanner.nextLine();
                            
                            if (confirm.equalsIgnoreCase("haa") || confirm.equalsIgnoreCase("yes") || confirm.equalsIgnoreCase("y")) {
                                System.out.println(isEnglish ? "\n[✔] Your account has been permanently closed. Goodbye!" 
                                                             : "\n[✔] Account-kaagii si joogto ah ayaa loo xiray. Nabadgelyo!");
                                running = false;
                                adminRunning = false;
                            } else {
                                System.out.println(isEnglish ? "\n[!] Account closure cancelled." 
                                                             : "\n[!] Heshiiskii xiridda waa la baajiyay.");
                            }
                        } else {
                            System.out.println(isEnglish ? "\n[✘] Invalid choice!" : "\n[✘] Dooro khaldan!");
                        }
                    }
                    break;
                }
                case 8: {
                    // --- CASE 8: BILL PAYMENT (ENGLISH ONLY) ---
                    boolean billEngRunning = true;
                    while (billEngRunning) {
                        System.out.println("\n--- BILL PAYMENT PANEL (ENGLISH) ---");
                        System.out.println("  1. Electricity Bill");
                        System.out.println("  2. Water Bill");
                        System.out.println("  3. Internet Bill");
                        System.out.println("  4. School Fees");
                        System.out.println("  5. Merchant Payment");
                        System.out.println("  6. Go Back");
                        System.out.println("------------------------------------");
                        System.out.print("Select bill option (1-6): ");
                        
                        if (!scanner.hasNextInt()) {
                            System.out.println("\n[✘] Invalid input! Please enter a number.");
                            scanner.nextLine();
                            continue;
                        }
                        
                        int engBillChoice = scanner.nextInt();
                        scanner.nextLine(); // Clear buffer
                        
                        if (engBillChoice == 6) {
                            billEngRunning = false;
                            break;
                        }
                        
                        String billName = "";
                        if (engBillChoice == 1) billName = "Electricity";
                        else if (engBillChoice == 2) billName = "Water";
                        else if (engBillChoice == 3) billName = "Internet";
                        else if (engBillChoice == 4) billName = "School Fees";
                        else if (engBillChoice == 5) billName = "Merchant Payment";
                        else {
                            System.out.println("\n[✘] Invalid choice!");
                            continue;
                        }
                        
                        System.out.print("Enter Account or Merchant ID: ");
                        String billId = scanner.nextLine();
                        
                        System.out.print("Enter amount to pay: $");
                        double amount = scanner.nextDouble();
                        scanner.nextLine(); // Clear buffer
                        
                        if (amount <= 0) {
                            System.out.println("\n[✘] Invalid amount entered!");
                            continue;
                        }
                        if (amount > balance) {
                            System.out.println("\n[✘] Insufficient wallet balance!");
                            continue;
                        }
                        
                        System.out.print("Enter PIN: ");
                        String enteredPin1 = scanner.nextLine();
                        System.out.print("Confirm PIN (Repeat): ");
                        String enteredPin2 = scanner.nextLine();
                        
                        if (enteredPin1.equals(enteredPin2)) {
                            if (enteredPin1.equals(pin)) {
                                balance -= amount;
                                System.out.println("\n------------------------------------------");
                                System.out.printf("[✔] Bill Payment Successful!\n" +
                                                  "You paid $%.2f for %s service.\n" +
                                                  "Merchant/Account ID: %s\n" +
                                                  "Your remaining wallet balance is: $%.2f\n", 
                                                  amount, billName, billId, balance);
                                System.out.println("------------------------------------------");
                            } else {
                                System.out.println("\n[✘] Incorrect PIN! Bill payment failed.");
                            }
                        } else {
                            System.out.println("\n[✘] PINs do not match! Bill payment failed.");
                        }
                    }
                    break;
                }
                case 9: {
                    // --- CASE 9: EXIT ---
                    System.out.println("\n*************************************************");
                    System.out.println(isEnglish ? "*    Thank you for using JEEP Mobile Money.     *" 
                                                 : "*  Mahadsanid isticmaalka JEEP Mobile Money.    *");
                    System.out.println("*************************************************");
                    running = false;
                    break;
                }
                default: {
                    System.out.println(isEnglish ? "\n[✘] Invalid option! Please select between 1 and 9." 
                                                 : "\n[✘] Dooro khaldan! Fadlan dooro adeeg u dhexeeya 1 iyo 9.");
                }
            }
        }
        
        scanner.close(); // Xir Scanner-ka si aysan u dhicin memory leaks
    }
}