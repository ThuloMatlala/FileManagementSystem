public class CarClient {

    private IElectricCar iElectricCar;
    private IFossilFuelCar iFossilFuelCar;

    public CarClient(ICar benzFactory) {
        iElectricCar = benzFactory.GetElectrircCar();
        iFossilFuelCar = benzFactory.GetFossilFuelCar();
    }

    public String GetElectricCar(){
        return iElectricCar.GetModelDetails();
    }

    public String GetFossilFuelCar(){
        return iFossilFuelCar.GetModelDetails();
    }
}
