package com.project.rest_app.tools;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

public class Tools {

	public static final Random RANDOM = new Random();

	public static final List<String> FIRST_NAMES = Collections
			.unmodifiableList(Arrays.asList("Petr", "Marie", "Jan", "Jana", "Tomáš", "Kateřina", "Lukáš", "Tereza",
					"Martin", "Veronika", "David", "Eva", "Jakub", "Lucie", "Michal", "Anna", "Adam", "Monika", "Tom",
					"Klára", "Robert", "Kristýna", "Marek", "Simona", "Filip", "Petra", "Ondřej", "Lenka", "Matěj",
					"Markéta", "Pavel", "Hana", "Jakub", "Adéla", "Daniel", "Barbora", "Lukáš", "Eliška", "Josef"));
	public static final List<String> LAST_NAMES = Collections.unmodifiableList(Arrays.asList("Novák", "Svoboda",
			"Novotný", "Dvořák", "Černý", "Procházková", "Kučera", "Veselý", "Horák", "Němec", "Pokorný", "Mareš",
			"Pospíšilová", "Hájek", "Jelínek", "Král", "Růžička", "Beneš", "Fiala", "Sedláček", "Kříž", "Němcová",
			"Vlček", "Kolář", "Bartoš", "Bílý", "Veselá", "Kovařík", "Havelka", "Malý", "Urban", "Kopecký", "Vlach",
			"Šimek", "Konečný", "Doležal", "Šťastný", "Kopečná", "Holub", "Pospíchal"));

	public static final List<String> STREETS = Collections.unmodifiableList(
			Arrays.asList("Panská", "Hlavní", "Ulice Nová", "Náměstí Svobody", "Hřbitovní", "Revoluční", "Sadová",
					"Jiráskova", "Školní", "Vinohradská", "Komenského", "Mírová", "Křížová", "Masarykova",
					"Třída Svobody", "Karlova", "Dlouhá", "Žižkova", "Purkyňova", "Rybářská", "Sokolská", "Rybníček",
					"Vrchlického", "Štefánikova", "Veselá", "Lipová", "Na Hrázi", "Výšinná", "Nová Cesta", "Česká"));
	public static final List<String> CITIES = Collections.unmodifiableList(
			Arrays.asList("Praha", "Brno", "Ostrava", "Plzeň", "Liberec", "Olomouc", "České Budějovice",
					"Hradec Králové", "Ústí nad Labem", "Pardubice", "Zlín", "Karlovy Vary", "Jihlava", "Tábor",
					"Havířov", "Český Těšín", "Mladá Boleslav", "Trutnov", "Přerov", "Kladno", "Opava", "Frýdek-Místek",
					"Děčín", "Karviná", "Jablonec nad Nisou", "Třebíč", "Žďár nad Sázavou", "Kolín", "Uherské Hradiště",
					"Znojmo", "Prostějov", "Litoměřice", "Kroměříž", "Chomutov", "Příbram", "Příbram", "Cheb",
					"Teplice", "Uherský Brod", "Sokolov", "Břeclav", "Litvínov", "Klatovy", "Vsetín", "Nový Jičín"));

	public static final List<String> POST_NUMBER = Collections
			.unmodifiableList(Arrays.asList("10000", "11000", "12000", "13000", "14000", "15000", "16000", "17000",
					"18000", "19000", "20000", "21000", "22000", "23000", "24000", "25000", "26000", "27000", "28000",
					"29000", "30000", "31000", "32000", "33000", "34000", "35000", "36000", "37000", "38000", "39000"));

	public static final List<String> COMPANY_NAMES = Collections.unmodifiableList(Arrays.asList("Inova", "Sprint",
			"Polaris", "Forte", "Nexus", "Vertex", "Synergie", "Horizon", "Astra", "Axiom", "Optima", "Integra",
			"Evolve", "Apex", "Dynasty", "Eclipse", "Paragon", "Fusion", "Oasis", "Equinox", "Voyage", "Genesis",
			"Zenith", "Elite", "Harmony", "Stratos", "Aurora", "Quantum", "Spectrum"));

	public static final List<String> BIRD_NAMES = Collections.unmodifiableList(Arrays.asList("Vlaštovka", "Sýkorka",
			"Krkavec", "Sokol", "Káně", "Střízlík", "Sojka", "Datel", "Drozd", "Rorýs", "Husa", "Labuť", "Krahujec",
			"Sova", "Výr", "Husice", "Havran", "Špaček", "Ledňáček", "Sup"));

	public static final List<String> NICKNAMES = Collections
			.unmodifiableList(Arrays.asList("CyberSurfer", "PixelPioneer", "SocialSavvy", "DigitalDynamo", "ByteBuddy",
					"InstaGuru", "TikTokTornado", "SnapMaster", "TweetTrendsetter", "ChatChampion", "HashtagHero",
					"EmojiEnthusiast", "StoryStylist", "SelfieStar", "FilterFanatic", "VlogVirtuoso", "Memelord",
					"InfluencerInsider", "StreamSupreme", "GeekyGizmo", "CodeCommander", "JavaJuggernaut", "ByteNinja",
					"SyntaxSamurai", "ClassyCoder", "ObjectOmnipotent", "LoopLegend", "VariableVirtuoso", "DebugDemon",
					"CompilerCrusader", "PixelProdigy", "VirtualVoyager", "AlgorithmAce", "DataDynamo",
					"ExceptionExpert", "BugBuster", "SyntaxSorcerer", "CodeCrusader", "JavaJester"));

	public static final List<String> MOBILE_NUMBERS = generateMobileNumbers();

	private static List<String> generateMobileNumbers() {
		List<String> numbers = new ArrayList<>();
		for (int i = 0; i < 100; i++) {
			numbers.add(generateMobileNumber());
		}
		return Collections.unmodifiableList(numbers);
	}

	private static String generateMobileNumber() {
		return String.format("+420 %03d %03d %03d", RANDOM.nextInt(1000), RANDOM.nextInt(1000), RANDOM.nextInt(1000));
	}

	public static final List<String> PRODUCT_NAMES = Collections.unmodifiableList(Arrays.asList(
			"Smartfón", "Notebook", "Slúchadlá", "Smartwatch", "Tablet", "Digitálny fotoaparát", "Bezdrôtové slúchadlá",
			"Fitness náramok", "Externý pevný disk", "Bluetooth reproduktor", "Herná konzola", "Tlačiareň",
			"Stolný počítač", "Monitor", "USB disk", "Router", "Klávesnica", "Myš", "Grafická karta",
			"SSD disk", "Televízor", "Smart Home zariadenie", "Prenosná nabíjačka", "Akčná kamera", "Dron"));

	public static final List<String> PRODUCT_DESCRIPTIONS = Collections.unmodifiableList(Arrays.asList(
			"Nový model smartfónu s výkonným procesorom a veľkým displejom.",
			"Notebook vhodný pre pracovné aj herné účely s výkonným procesorom a grafickou kartou.",
			"Bezdrôtové slúchadlá s výborným zvukom a dlhou výdržou batérie.",
			"Smartwatch s množstvom funkcií, ako je monitorovanie tepu a krokov.",
			"Tablet s vysokým rozlíšením displeja a výkonným hardvérom.",
			"Digitálny fotoaparát s vysokým rozlíšením a rýchlym automatickým zaostrovaním.",
			"Bezdrôtové slúchadlá s výbornou izoláciou hluku a pohodlným dizajnom.",
			"Fitness náramok s množstvom funkcií pre sledovanie aktivity a spánku.",
			"Externý pevný disk s veľkou kapacitou na ukladanie dát a rýchlym prenosom údajov.",
			"Bluetooth reproduktor s výborným zvukom a odolným dizajnom.",
			"Herná konzola s vysokým výkonom a širokou ponukou hier.",
			"Tlačiareň s možnosťou farebného tlače a rýchlym tlačovým výstupom.",
			"Stolný počítač s výkonným procesorom a veľkým množstvom úložného priestoru.",
			"Monitor s vysokým rozlíšením a rýchlym časom odozvy.",
			"USB disk s malými rozmermi a veľkou kapacitou.",
			"Router s rýchlym pripojením k internetu a stabilným signálom.",
			"Klávesnica s ergonomickým dizajnom a odolnými tlačidlami.",
			"Myš s presným optickým snímačom a pohodlným úchopom.",
			"Grafická karta s vysokým výkonom a podporou najnovších hier.",
			"SSD disk s rýchlym načítaním a vysokou spoľahlivosťou.",
			"Televízor s vysokým rozlíšením a inteligentnými funkciami.",
			"Smart Home zariadenie s možnosťou ovládania cez aplikáciu a hlasový asistent.",
			"Prenosná nabíjačka s veľkou kapacitou a rýchlym nabíjaním.",
			"Akčná kamera s odolným dizajnom a vysokým rozlíšením záznamu.",
			"Dron s kamérou a možnosťou dlhého letu."));
	public static String generateCompanyName() {
		StringBuilder name = new StringBuilder();
		int numberOfWords = RANDOM.nextInt(2) + 1;
		for (int j = 0; j < numberOfWords; j++) {
			name.append(randomElementFrom(COMPANY_NAMES));
			if (j < numberOfWords - 1) {
				name.append(" ");
			}
		}
		return name.toString();
	}

	public static String generateAddress() {
		return String.format("%s %d, %s, %s", randomElementFrom(STREETS), RANDOM.nextInt(99) + 1,
				randomElementFrom(CITIES), randomElementFrom(POST_NUMBER));
	}

	public static <T> T randomElementFrom(List<T> list) {
		return randomElementFrom(list, RANDOM);
	}

	public static <T> T randomElementFrom(List<T> list, Random r) {
		if (list.isEmpty()) {
			return null;
		}
		return list.get(r.nextInt(list.size()));
	}

	public static LocalDate generatePreviousDate() {
		return LocalDate.of(LocalDate.now().getYear() - RANDOM.nextInt(80), RANDOM.nextInt(12) + 1, 1)
				.plusDays(RANDOM.nextInt(31));
	}

	public static LocalDate generateDateInFuture() {
		return LocalDate.now().plusDays(RANDOM.nextInt(400));
	}

	public static LocalDateTime generatePreviousDateTime() {
		return LocalDateTime.now().minusMinutes(RANDOM.nextInt(50000));
	}

	private Tools() {
		/* hide public one - nothing to do */
	}
}
