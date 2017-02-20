class Services {

    protected String name;
	protected double monthly_fee;

	public Services() {
	}

	public Services(String name, double fee) {
		this.name = name;
		monthly_fee = fee;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public double getMonthly_fee() {
		return monthly_fee;
	}

	public void setMonthly_fee(double monthly_fee) {
		this.monthly_fee = monthly_fee;
	}

	@Override
	public String toString() {
		return "Services [name=" + name + ", monthly_fee=" + monthly_fee + "]";
	}

}
class Mobile_telephony_services extends Services {

	public double charge_Talking;//charge per minute
	private double charge_Sms;//charge per sms
	public static int discount;//if discount : 10% then discount=10

	public Mobile_telephony_services() {
	}

	public Mobile_telephony_services(String name, double monthly_fee,
			double charge_Talking, double charge_Sms, int discount) {
		super(name, monthly_fee);
		this.charge_Talking = charge_Talking;
		this.charge_Sms = charge_Sms;
		Mobile_telephony_services.discount = discount;
	}

	public double getCharge_Sms() {
		return charge_Sms;
	}

	public void setCharge_Sms(double charge_Sms) {
		this.charge_Sms = charge_Sms;
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		Mobile_telephony_services.discount = discount;
	}

	public static double priceAfterDiscount(double price, double discount) {
		return price - price * discount / 100;
	}

	@Override
	public String toString() {
		return "Mobile_telephony_services [charge_Talking=" + charge_Talking
				+ ", charge_Sms=" + charge_Sms + ", name=" + name
				+ ", monthly_fee=" + monthly_fee + "]";
	}

}
public class Main {

	public static void main(String[] args){
		Mobile_telephony_services service = new Mobile_telephony_services();
		service.setMonthly_fee(12.20);
		service.setName("unlimited 4");
		service.setCharge_Sms(1.1);
		System.out.println(service.toString());
		
		Mobile_telephony_services.discount = 15;
		Mobile_telephony_services m = new Mobile_telephony_services();
		m.charge_Talking = 0.3;
		//m.charge_Sms = 1.1;
		m.setCharge_Sms(1.1);
		m.setName("ServiceName1");
		m.setMonthly_fee(2);
		System.out.println(m.toString());
	}
}