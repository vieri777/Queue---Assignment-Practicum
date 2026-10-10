/**
 * Class Queue: antrean Customer Service dengan prinsip FIFO
 * (First In First Out), diimplementasikan dengan linked node
 * sehingga ukurannya tidak dibatasi.
 */
public class Queue {

	// Node internal penyimpan satu Customer
	private static class Node {
		Customer data;
		Node next;

		Node(Customer data) {
			this.data = data;
		}
	}

	private Node front;   // pelanggan yang akan dilayani berikutnya
	private Node rear;    // pelanggan yang paling akhir masuk
	private int size;
	private int counterNomor = 0; // nomor antrean otomatis

	/** Fitur 1: tambah pelanggan ke belakang antrean. */
	public Customer tambahPelanggan(String nama, String keperluan) {
		// Validasi dulu (di constructor Customer); nomor hanya naik jika berhasil
		Customer pelanggan = new Customer(counterNomor + 1, nama, keperluan);
		counterNomor++;
		Node baru = new Node(pelanggan);

		if (isEmpty()) {
			front = baru;
			rear = baru;
		} else {
			rear.next = baru;
			rear = baru;
		}
		size++;
		return pelanggan;
	}

	/** Fitur 2: layani pelanggan terdepan, lalu keluarkan dari antrean. */
	public Customer layaniPelanggan() {
		if (isEmpty()) {
			return null; // tidak ada yang dilayani
		}
		Customer dilayani = front.data;
		front = front.next;
		if (front == null) {
			rear = null;
		}
		size--;
		return dilayani;
	}

	/** Fitur 3: tampilkan seluruh isi antrean dari depan ke belakang. */
	public void tampilkanAntrean() {
		if (isEmpty()) {
			System.out.println("Antrean kosong.");
			return;
		}
		System.out.println("=== Daftar Antrean (" + size + " pelanggan) ===");
		Node current = front;
		int posisi = 1;
		while (current != null) {
			System.out.println(posisi + ". " + current.data);
			current = current.next;
			posisi++;
		}
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public int getSize() {
		return size;
	}

	/** Melihat pelanggan terdepan tanpa mengeluarkannya. */
	public Customer peek() {
		return isEmpty() ? null : front.data;
	}
}