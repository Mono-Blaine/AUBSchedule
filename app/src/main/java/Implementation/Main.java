package Implementation;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	private static String[] links = new String[] {
			"https://www-banner.aub.edu.lb/catalog/schd_A.htm", 
			"https://www-banner.aub.edu.lb/catalog/schd_B.htm",
			"https://www-banner.aub.edu.lb/catalog/schd_C.htm",
			"https://www-banner.aub.edu.lb/catalog/schd_D.htm",
			"https://www-banner.aub.edu.lb/catalog/schd_E.htm",
			"https://www-banner.aub.edu.lb/catalog/schd_F.htm",
			"https://www-banner.aub.edu.lb/catalog/schd_G.htm",
			"https://www-banner.aub.edu.lb/catalog/schd_H.htm",
			"https://www-banner.aub.edu.lb/catalog/schd_I.htm",
			"https://www-banner.aub.edu.lb/catalog/schd_J.htm",
			"https://www-banner.aub.edu.lb/catalog/schd_K.htm",
			"https://www-banner.aub.edu.lb/catalog/schd_L.htm",
			"https://www-banner.aub.edu.lb/catalog/schd_M.htm",
			"https://www-banner.aub.edu.lb/catalog/schd_N.htm",
			"https://www-banner.aub.edu.lb/catalog/schd_O.htm",
			"https://www-banner.aub.edu.lb/catalog/schd_P.htm",
			"https://www-banner.aub.edu.lb/catalog/schd_Q.htm",
			"https://www-banner.aub.edu.lb/catalog/schd_R.htm",
			"https://www-banner.aub.edu.lb/catalog/schd_S.htm",
			"https://www-banner.aub.edu.lb/catalog/schd_T.htm",
			"https://www-banner.aub.edu.lb/catalog/schd_U.htm",
			"https://www-banner.aub.edu.lb/catalog/schd_V.htm",
			"https://www-banner.aub.edu.lb/catalog/schd_W.htm",
			"https://www-banner.aub.edu.lb/catalog/schd_X.htm",
			"https://www-banner.aub.edu.lb/catalog/schd_Y.htm",
			"https://www-banner.aub.edu.lb/catalog/schd_Z.htm"
	};
	
	public static void main(String[] args) {
		List<Course> courses = new ArrayList<Course>();

		//Downloader downloader = new Downloader();
		//HtmlToCsv toCsv = new HtmlToCsv();
		//CsvToDb toDb = new CsvToDb();
		
		// download the HTML file for every letter, create its CSV, and add the contained courses to courses, the list of type Course
		for (int i = 0; i < 26; i++) {
			System.out.println("\t\t<<...Loading " + (char) (i+65) + "'s...>>");
			
			String htmlFile = (char) (i + 65) + ".txt";
			String csvFile = (char) (i + 65) + "csv.txt";
			
			//downloader.downloadHtmlToFile(links[i], htmlFile);
			//toCsv.htmlToCsv(htmlFile, csvFile);
			//toDb.csvToDb(courses, csvFile);
		}
		
		System.out.println(courses.size() + " courses loaded");

		Scanner scanner = new Scanner(System.in);
		Print print = new Print();
		print.printMethods();
		
		CourSeera seer = new CourSeeraFactory().createInstance(courses, "Fall 2021-2022(202210)");

		char exit = '1';
		String line;
		while (exit != '0') {
			line = scanner.nextLine();
			String[] command = line.split(" ");
			
			if (command[0].compareTo("profSchedule") == 0 || command[0].compareTo("whereIsProf") == 0
				|| command[0].compareTo("whereWillProfBe") == 0) {

					// in case the last name is 2 words or more (for eg. nahas el-zein)
					String lastName = "";
					for (int i = 2; i < command.length; i++)
						lastName += command[i] + " ";
					lastName = lastName.substring(0, lastName.length()-1);
					
					Instructor i = new Instructor(command[1], lastName);
					
					if (command[0].compareTo("profSchedule") == 0)
						print.printRoomSchedule(seer.profSchedule(i));
					else if (command[0].compareTo("whereIsProf") == 0)
						print.printProfNow(seer.whereIsProf(i));
					else if (command[0].compareTo("whereWillProfBe") == 0)
						print.printProfWillBe(seer.whereWillProfBe(i));
					continue;
				}

			switch (command.length) {
			case 1:
				if (command[0].compareTo("0") == 0) {
					exit = command[0].charAt(0);
					break;
				}
				if (command[0].compareTo("roomSchedule") == 0)
					print.printRoomSchedule(seer.roomSchedule());
				break;
				
			case 3:
				Room r = new Room(command[1], command[2]);
				if (command[0].compareTo("roomSchedule") == 0) 
					print.printRoomSchedule(seer.roomSchedule(r));
				else if (command[0].compareTo("whoWasThereLast") == 0)
					print.printThere(seer.whoWasThereLast(r));
				else if (command[0].compareTo("whoIsThereNow") == 0)
					print.printThere(seer.whoIsThereNow(r));
				break;
				
			case 4:
				if (command[0].compareTo("roomSchedule") == 0) {
					Room r1 = new Room(command[1], command[2]);
					if (command[3].toLowerCase().compareTo("monday") == 0)
						print.printRoomScheduleDay(seer.roomSchedule(r1, java.time.DayOfWeek.MONDAY), java.time.DayOfWeek.MONDAY);
					else if (command[3].toLowerCase().compareTo("tuesday") == 0)
						print.printRoomScheduleDay(seer.roomSchedule(r1, java.time.DayOfWeek.TUESDAY), java.time.DayOfWeek.TUESDAY);
					else if (command[3].toLowerCase().compareTo("wednesday") == 0)
						print.printRoomScheduleDay(seer.roomSchedule(r1, java.time.DayOfWeek.WEDNESDAY), java.time.DayOfWeek.WEDNESDAY);
					else if (command[3].toLowerCase().compareTo("thursday") == 0)
						print.printRoomScheduleDay(seer.roomSchedule(r1, java.time.DayOfWeek.THURSDAY),  java.time.DayOfWeek.THURSDAY);
					else if (command[3].toLowerCase().compareTo("friday") == 0)
						print.printRoomScheduleDay(seer.roomSchedule(r1, java.time.DayOfWeek.FRIDAY), java.time.DayOfWeek.FRIDAY);
					else if (command[3].toLowerCase().compareTo("saturday") == 0)
						print.printRoomScheduleDay(seer.roomSchedule(r1, java.time.DayOfWeek.SATURDAY), java.time.DayOfWeek.SATURDAY);
					break;
				}
				
			case 6:
				if (command[0].compareTo("roomSchedule") == 0) {
					try {
						Room r2 = new Room(command[1], command[2]);
						LocalDate date = LocalDate.of(Integer.parseInt(command[3]), Integer.parseInt(command[4]),
								Integer.parseInt(command[5]));
						print.printRoomScheduleDay(seer.roomSchedule(r2, date), date.getDayOfWeek());
						break;
					}
					catch (Exception e) {
						System.out.println("<< Invalid parameters >>");
						break;
					}
				}
				
			default:
				System.out.println("<< Invalid command >>");
				break;
			}
		}
		scanner.close();

		System.out.println("Done");
	}
}
