public class Benz implements ICar {
    public IElectricCar GetElectrircCar() {
        return new BenzEQ2();
    }

    public IFossilFuelCar GetFossilFuelCar() {
        return new BenzC63();
    }
}
