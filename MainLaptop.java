package Java_introduction_Final_HW;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class MainLaptop {

        public static void main(String[] args) {

                List<Laptop> list = addInCatalogLaptop();  //переносим список всех ноутбуков в main

                Map<String, String> filterSave = new LinkedHashMap<>(); // создаем словарь для сохранения критериев фильтрации

                // создаем спискок, используется для вывода сообщения о состоянии фильтра, где значения указаны с еденицами измерения
                List<String> printFilter = new ArrayList<>();  

                // создаем список "критерии фильтра" для 1 уровня
                List<String> listFilter = new ArrayList<>(
                                Arrays.asList("Стоимость", "ОЗУ", "Объем ЖД", "Операционная система", "Бренд"));

                // запускаем настройку фильтра
                menuFilter(filterSave, printFilter, listFilter, list);
        }

         /**
         * Метод для добавления ноутбуков в каталог 
         * @return
         */
        private static List<Laptop> addInCatalogLaptop() {
                List<Laptop> listCatalog = new ArrayList<>();
                listCatalog.add(new Laptop(8, 512, "macOS", "Apple", 163_799));
                listCatalog.add(new Laptop(16, 512, "macOS", "Apple", 302_699));
                listCatalog.add(new Laptop(8, 240, "Windows 10 Pro", "Echips", 30_999));
                listCatalog.add(new Laptop(4, 128, "Windows 11 Pro", "ASUS", 39_999));
                listCatalog.add(new Laptop(8, 256, "Windows 11 Home", "Acer", 48_299));
                listCatalog.add(new Laptop(16, 1000, "Без ОС", "MSI", 104_999));
                listCatalog.add(new Laptop(16, 1000, "Windows 11 Home", "Huawei", 129_999));
                listCatalog.add(new Laptop(16, 1024, "macOS", "Apple", 230_599));
                listCatalog.add(new Laptop(32, 2000, "Без ОС", "AORUS", 324_999));
                listCatalog.add(new Laptop(16, 512, "Linux", "Maibenben", 86_999));
                listCatalog.add(new Laptop(6, 128, "Windows 11 Pro", "Echips", 25_999));
                listCatalog.add(new Laptop(64, 2000, "Windows 11 Pro", "Machenike", 329_999));

                return listCatalog;
        }

        /**
         * Фильтр 1 уровня
         * @param filterSave словарь для сохранения выбранных критериев фильтра
         * @param printFilter список для печати информации о выбранных критериях фильтра
         * @param listFilter список критерии фильтра основной (1 уровень)
         * @param list список всех ноутбуков
         */
        private static void menuFilter(Map<String, String> filterSave, List<String> printFilter,
                List<String> listFilter, List<Laptop> list) {
                List<Laptop> catalog = addInCatalogLaptop();

                Map<Integer, String> options = printOptions(listFilter, "Показать все");

                Scanner sc = new Scanner(System.in);
                int option_key = getOption_key("Выберите действие:", sc);

                switch (option_key) {
                        case 1:
                                int priceValue = getOption_key("Введите минимальное значение для критерия "
                                                + options.get(option_key) + " в рублях: ", sc);
                                filterSave.put(options.get(option_key), Integer.toString(priceValue));
                                printFilter.add(options.get(option_key) + ": от " + priceValue + " руб");
                                printMessage(printFilter, "Фильтр установлен: ");
                                filterCatalog(filterSave, list, printFilter);
                                menuFilter2(sc, filterSave, printFilter, listFilter, list);
                                break;
                        case 2:
                                int ramValue = getOption_key("Введите минимальное значение для критерия "
                                                + options.get(option_key) + " в Гб: ", sc);
                                filterSave.put(options.get(option_key), Integer.toString(ramValue));
                                printFilter.add(options.get(option_key) + ": от " + ramValue + " Гб");
                                printMessage(printFilter, "Фильтр установлен: ");
                                filterCatalog(filterSave, list, printFilter);
                                menuFilter2(sc, filterSave, printFilter, listFilter, list);
                                break;
                        case 3:
                                int hdCapacityValue = getOption_key("Введите минимальное значение для критерия "
                                                + options.get(option_key) + " в Гб: ", sc);
                                filterSave.put(options.get(option_key), Integer.toString(hdCapacityValue));
                                printFilter.add(options.get(option_key) + ": от " + hdCapacityValue + " Гб");
                                printMessage(printFilter, "Фильтр установлен: ");
                                filterCatalog(filterSave, list, printFilter);
                                menuFilter2(sc, filterSave, printFilter, listFilter, list);
                                break;
                        case 4:
                                Map<Integer, String> optionsOS = printOptions(getListOS(filterCatalog(filterSave, list, printFilter)), "Сбросить фильтр");
                                int osValue = getOption_key("Введите цифру, соответствующую необходимому значению "
                                                + options.get(option_key) + " : ", sc);
                                filterSave.put(options.get(option_key), optionsOS.get(osValue));
                                printFilter.add(options.get(option_key) + ": " + optionsOS.get(osValue));
                                printMessage(printFilter, "Фильтр установлен: ");
                                filterCatalog(filterSave, list, printFilter);
                                menuFilter2(sc, filterSave, printFilter, listFilter, list);
                                break;
                        case 5:
                                Map<Integer, String> optionsBrand = printOptions(getListBrand(filterCatalog(filterSave, list, printFilter)), "Сбросить фильтр");
                                int brandValue = getOption_key("Введите цифру, соответствующую необходимому критерию "
                                                + options.get(option_key) + " : ", sc);
                                filterSave.put(options.get(option_key), optionsBrand.get(brandValue));
                                printFilter.add(options.get(option_key) + ": " + optionsBrand.get(brandValue));
                                printMessage(printFilter, "Фильтр установлен: ");
                                filterCatalog(filterSave, list, printFilter);
                                menuFilter2(sc, filterSave, printFilter, listFilter, list);
                                break;
                        case 0:
                                printFilter.add(options.get(option_key));
                                printMessage(printFilter, "Фильтр установлен: ");
                                printCatalog(catalog);
                                break;
                        default:
                                System.out.println("Введены не корректные данные!");
                }
                sc.close();
        }

        /**
         * Фильтр 2 уровня
         * @param sc сканер для получения данных от пользователя
         * @param filterSave словарь для сохранения выбранных критериев фильтра (указан в аргументах т.к. внутри этого метода вызывается menuFilter - фильтр 1 уровня)
         * @param printFilter список для печати информации о выбранных критериях фильтра (указан в аргументах т.к. внутри этого метода вызывается menuFilter - фильтр 1 уровня)
         * @param listFilter список критерии фильтра основной (1 уровень) (указан в аргументах т.к. внутри этого метода вызывается menuFilter - фильтр 1 уровня)
         * @param list список всех ноутбуков (указан в аргументах т.к. внутри этого метода вызывается menuFilter - фильтр 1 уровня)
         */
        private static void menuFilter2(Scanner sc, Map<String, String> filterSave, List<String> printFilter,
                                        List<String> listFilter, List<Laptop> list) {

                List<String> listNextAct = new ArrayList<>(Arrays.asList("Продолжить настройку фильтра"));
                printOptions(listNextAct, "Сбросить фильтр");

                int option_key = getOption_key("Выберите действие:", sc);
                switch (option_key) {
                        case 0:
                                break;
                        case 1:
                                menuFilter(filterSave, printFilter, listFilter, list);
                                break;
                        default:
                                System.out.println("Введены не корректные данные!");
                }
        }

        /**
         * Метод для печати критерии фильтра
         * @param array список содержащий критерии для фильтра
         * @return
         */
        private static Map<Integer, String> printOptions(List<String> array, String text) {
                System.out.println();
                Map<Integer, String> options = new LinkedHashMap<>();
                options.put(0, text);

                for (int i = 0; i < array.size(); i++) {
                        options.put(i + 1, array.get(i));
                }

                for (var item : options.entrySet()) {
                        System.out.printf("%d: %s\n", item.getKey(), item.getValue());
                }
                System.out.println();

                return options;
        }

        /**
         * Метод для получения от пользователя данных (ключ для настройки фильтра)
         * @param text сообщение предлагающий выбрать действие
         * @param sc сканер для получения данных от пользователя
         * @return
         */
        private static int getOption_key(String text, Scanner sc) {

                System.out.print(text);
                int option_key = sc.nextInt();

                return option_key;
        }


        /**
         * Метод для вывода информации о выбранных критериях фильтра
         * @param printFilter список для печати информации о выбранных критериях фильтра
         * @param text пояснительное сообщение к printFilter
         */
        private static void printMessage(List<String> printFilter, String text) {
                System.out.println();
                System.out.print(text + printFilter);
                System.out.println();
        }


        /**
         * Метод для печати каталога
         * @param list список ноутбуков
         */
        private static void printCatalog(List<Laptop> list) {
                Set<Laptop> catalog = new HashSet<>(list);

                for (Laptop laptop : catalog) {
                        System.out.println(laptop);
                }
                System.out.println();
        }

        /**
         * Метод для получения списка уникальных значений бренда
         * @param list список ноутбуков
         * @return
         */
        private static List<String> getListBrand(List<Laptop> list) {

                Set<String> setBrand = new HashSet<>();

                for (Laptop lap : list) {
                        setBrand.add(lap.getBrand());
                }
                List<String> listBrand = new ArrayList<>(setBrand);

                return listBrand;
        }

        /**
         * Метод для получения списка уникальных значений операционной системы
         * @param list список ноутбуков
         * @return
         */
        private static List<String> getListOS(List<Laptop> list) {
                Set<String> setOS = new HashSet<>();

                for (Laptop lap : list) {
                        setOS.add(lap.getOs());
                }
                List<String> listOS = new ArrayList<>(setOS);

                return listOS;
        }


        /**
         * Метод для получения списка ноутбуков согласно выбранным критериям фильтра
         * @param filterSave словарь с сохраненными критериями фильтра
         * @param list список всех ноутбуков
         * @param printFilter список для печати информации о выбранных критериях фильтра
         */
        private static List<Laptop> filterCatalog(Map<String, String> filterSave, List<Laptop> list, List<String> printFilter) {
                List<Laptop> listFilterCatalog = new ArrayList<>(list);
                filterSave.put("Сбросить фильтр", "0");
                Set<String> keys = filterSave.keySet();
                // if (listFilterCatalog.isEmpty()) {
                //         System.out.println();
                //         System.out.println("По запросу " + printFilter + " значения не найдены.");
                //         System.out.println();

                for (String key : keys) {
                        switch (key) {
                                case "Стоимость":
                                        int priceFilter = Integer.parseInt(filterSave.get(key));
                                        for (int index = 0; index < listFilterCatalog.size(); index++) {
                                                int priceLaptop = listFilterCatalog.get(index).getPrice();
                                                if (priceLaptop < priceFilter) {
                                                        listFilterCatalog.remove(listFilterCatalog.get(index));
                                                        index--;
                                                }
                                        }
                                        break;
                                case "ОЗУ":
                                        int ramFilter = Integer.parseInt(filterSave.get(key));
                                        for (int index = 0; index < listFilterCatalog.size(); index++) {

                                                int ramLaptop = listFilterCatalog.get(index).getRam();
                                                if (ramLaptop < ramFilter) {
                                                        listFilterCatalog.remove(listFilterCatalog.get(index));
                                                        index--;
                                                }
                                        }
                                        break;
                                case "Объем ЖД":
                                        int hdCapacityFilter = Integer.parseInt(filterSave.get(key));
                                        for (int index = 0; index < listFilterCatalog.size(); index++) {

                                                int hdCapacityLaptop = listFilterCatalog.get(index).getHdCapacity();
                                                if (hdCapacityLaptop < hdCapacityFilter) {
                                                        listFilterCatalog.remove(listFilterCatalog.get(index));
                                                        index--;
                                                }
                                        }
                                        break;
                                case "Операционная система":
                                        String osFilter = filterSave.get(key);
                                        for (int index = 0; index < listFilterCatalog.size(); index++) {

                                                String osLaptop = listFilterCatalog.get(index).getOs();
                                                if (osLaptop != osFilter) {
                                                        listFilterCatalog.remove(listFilterCatalog.get(index));
                                                        index--;
                                                }
                                        }

                                        break;
                                case "Бренд":
                                        String brandFilter = filterSave.get(key);
                                        for (int index = 0; index < listFilterCatalog.size(); index++) {

                                                String brandLaptop = listFilterCatalog.get(index).getBrand();
                                                if (brandLaptop != brandFilter) {
                                                        listFilterCatalog.remove(listFilterCatalog.get(index));
                                                        index--;
                                                }
                                        }
                                        break;
                                case "Сбросить фильтр":
                                        break;                                       
                                default:
                                        System.out.println("Нет ноутбуков соответствующие критериям фильтрации");
                                        break;
                        }

                }

                //printMessage(printFilter, "Список ноутбуков выбранные по фильтру: ");
                printCatalog(listFilterCatalog);

                return listFilterCatalog;
        }

}
