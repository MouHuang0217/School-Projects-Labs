
class PhoneStore {
	public Phone getClone(Phone phone) {
		return (Phone) phone.makeCopy();
	}
}
