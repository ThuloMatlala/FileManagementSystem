public class ProgramStart {

    public static void main(String[] args) {
        ICar benzFactory = new Benz();
        CarClient benzClient = new CarClient(benzFactory);
        System.out.println(benzClient.GetElectricCar());
        System.out.println(benzClient.GetFossilFuelCar());

        ICar fordFactory = new Ford();
        CarClient fordClient = new CarClient(fordFactory);
        System.out.println(fordClient .GetElectricCar());
        System.out.println(fordClient .GetFossilFuelCar());
    }

}
