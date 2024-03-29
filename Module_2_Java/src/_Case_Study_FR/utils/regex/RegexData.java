package _Furama_Resort.utils.regex;

import _Furama_Resort.exception.*;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.regex.Pattern;

public class RegexData {
    public static Scanner scanner = new Scanner(System.in);
    private static final String REGEX_STR = "^[test.A-Z][a-z0-9]+$"; // tên dịch vụ
    private static final String REGEX_ID_VILLA = "^SVVL-[0-9]{4}$"; // mã dv
    private static final String REGEX_ID_HOUSE = "^SVHO-[0-9]{4}$";
    private static final String REGEX_ID_ROOM = "^SVRO-[0-9]{4}$";
    private static final String REGEX_AREA = "^([3-9]\\d)|([1-9]\\d{2,})$"; // dt sd, dt pool  > 30m2
    private static final String REGEX_INT = "^[1-9]{1,}$"; // chi phí thuê, số tầng
    private static final String REGEX_PEOPLE = "^[1-9]|([1][0-9])|(20)$"; // số ng tối đa

    public static String regexData(String temp, String regex, String error) {
        boolean check = true;
        do {
            if (temp.matches(regex)) {
                check = false;
            } else {
                System.out.println(error);
                temp = scanner.nextLine();
            }
        } while (check);
        return temp;
    }

    public static String regexIdVilla(String regex) {
        boolean check = true;
        String temp;
        do {
            temp = scanner.nextLine();
            check = false;
            try {
                if (!temp.matches(regex)) {
                    check = true;
                    throw new InvalidVillaIdException("Error: Incorrect Format..[SVVL-YYYY]..Enter Again: ");
                }
            } catch (InvalidVillaIdException e) {
                System.out.println(e.getMessage());
            }
        } while (check);
        return temp;
    }

    public static String regexIdHouse(String regex) {
        boolean check = true;
        String temp;
        do {
            temp = scanner.nextLine();
            check = false;
            try {
                if (!temp.matches(regex)) {
                    check = true;
                    throw new InvalidHouseIdException("Error: Incorrect Format..[SVHO-YYYY]..Enter Again: ");
                }
            } catch (InvalidHouseIdException e) {
                System.out.println(e.getMessage());
            }
        } while (check);
        return temp;
    }

    public static String regexIdRoom(String regex) {
        boolean check = true;
        String temp;
        do {
            temp = scanner.nextLine();
            check = false;
            try {
                if (!temp.matches(regex)) {
                    check = true;
                    throw new InvalidRoomIdException("Error: Incorrect Format..[SVRO-YYYY]..Enter Again: ");
                }
            } catch (InvalidRoomIdException e) {
                System.out.println(e.getMessage());
            }
        } while (check);
        return temp;
    }

    public static String regexStr(String regex) {
        boolean check = true;
        String temp;
        do {
            temp = scanner.nextLine();
            check = false;
            try {
                if (!temp.matches(regex)) {
                    check = true;
                    throw new InvalidStringException("Error: Incorrect Format..Enter Again: ");
                }
            } catch (InvalidStringException e) {
                System.out.println(e.getMessage());
            }
        } while (check);
        return temp;
    }

    public static String regexArea(String regex) {
        boolean check = true;
        String temp;
        do {
            temp = scanner.nextLine();
            check = false;
            try {
                if (!temp.matches(regex)) {
                    check = true;
                    throw new InvalidAreaException("Error: Incorrect Format..Use Area > 30m2..Enter Again: ");
                }
            } catch (InvalidAreaException e) {
                System.out.println(e.getMessage());
            }
        } while (check);
        return temp;
    }

    public static String regexInt(String regex) {
        boolean check = true;
        String temp;
        do {
            temp = scanner.nextLine();
            check = false;
            try {
                if (!temp.matches(regex)) {
                    check = true;
                    throw new InvalidIntegerException("Error: Incorrect Format: Enter Number > 0..Enter Again: ");
                }
            } catch (InvalidIntegerException e) {
                System.out.println(e.getMessage());
            }
        } while (check);
        return temp;
    }

    public static String regexPeople(String regex) {
        boolean check = true;
        String temp;
        do {
            temp = scanner.nextLine();
            check = false;
            try {
                if (!temp.matches(regex)) {
                    check = true;
                    throw new InvalidPeopleException("Error: Incorrect Format..0 < Max People < 20..Enter Again: ");
                }
            } catch (InvalidPeopleException e) {
                System.out.println(e.getMessage());
            }
        } while (check);
        return temp;
    }

    public static String regexAge(String temp, String regex) {
        boolean check = true;
        while (check) {
            try {
                if (Pattern.matches(regex, temp)) {
                    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                    LocalDate age = LocalDate.parse(temp, dateTimeFormatter);
                    LocalDate now = LocalDate.now();
                    int current = Period.between(age, now).getYears();
                    if (current < 100 && current > 18) {
                        check = false;
                    } else {
                        throw new AgeException("Age Must > 18 and < 100.");
                    }
                } else {
                    throw new AgeException("Incorrect Format.. Enter Again: ");
                }
            } catch (AgeException e) {
                System.out.println(e.getMessage());
                temp = scanner.nextLine();
            }
        }
        return temp;
    }

    public static String inputIdVilla() {
        System.out.println("Enter Id Villa: ");
        return RegexData.regexIdVilla(REGEX_ID_VILLA);
    }

    public static String inputIdHouse() {
        System.out.println("Enter Id House: ");
        return RegexData.regexIdHouse(REGEX_ID_HOUSE);
    }

    public static String inputIdRoom() {
        System.out.println("Enter Id Room: ");
        return RegexData.regexIdRoom(REGEX_ID_ROOM);
    }

    public static String inputName() {
        System.out.println("Enter Name Service: ");
        return RegexData.regexStr(REGEX_STR);
    }

    public static String inputUseArea() {
        System.out.println("Enter Area Use: ");
        return RegexData.regexArea(REGEX_AREA);
    }

    public static String inputAreaPool() {
        System.out.println("Enter Area Pool: ");
        return RegexData.regexArea(REGEX_AREA);
    }

    public static String inputRentalPrice() {
        System.out.println("Enter Rental Price: ");
        return RegexData.regexInt(REGEX_INT);
    }

    public static String inputPeopleMax() {
        System.out.println("Enter Rental People Max: ");
        return RegexData.regexPeople(REGEX_PEOPLE);
    }

    public static String inputFloor() {
        System.out.println("Enter Floor Villa: ");
        return RegexData.regexInt(REGEX_INT);
    }

    public static String inputStandardVilla() {
        System.out.println("Enter Standard Villa: ");
        return RegexData.regexIdVilla(REGEX_STR);
    }

    public static String inputStandardHouse() {
        System.out.println("Enter Standard House: ");
        return RegexData.regexIdVilla(REGEX_STR);
    }
}
