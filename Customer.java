/**
 * Class Customer: merepresentasikan satu pelanggan dalam antrean Customer Service.
 */
public class Customer {
	private final int nomorAntrean;
	private final String nama;
	private final String keperluan;

	public Customer(int nomorAntrean, String nama, String keperluan) {
		if (nama == null || nama.trim().isEmpty()) {
			throw new IllegalArgumentException("Nama pelanggan tidak boleh kosong");
		}
		this.nomorAntrean = nomorAntrean;
		this.nama = nama.trim();
		this.keperluan = (keperluan == null) ? "-" : keperluan.trim();
	}

	public int getNomorAntrean() {
		return nomorAntrean;
	}

	public String getNama() {
		return nama;
	}

	public String getKeperluan() {
		return keperluan;
	}

	@Override
	public String toString() {
		return "No. " + nomorAntrean + " | " + nama + " | Keperluan: " + keperluan;
	}
}