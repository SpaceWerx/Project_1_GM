package Models;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Reimbursement {
	protected int ID;
	protected int author;
	protected int resolver;
	protected String description;
	protected double amount;
	
	public Reimbursement() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Reimbursement(int iD, int author, int resolver, String description, Type other, Status pending, double amount) {
		super();
		ID = iD;
		this.author = author;
		this.resolver = resolver;
		this.description = description;
		this.amount = amount;
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public int getAuthor() {
		return author;
	}
	public void setAuthor(int author) {
		this.author = author;
	}
	public int getResolver() {
		return resolver;
	}
	public void setResolver(int resolver) {
		this.resolver = resolver;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	@Override
	public int hashCode() {
		return Objects.hash(ID, amount, author, description, resolver);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Reimbursement other = (Reimbursement) obj;
		return ID == other.ID && Double.doubleToLongBits(amount) == Double.doubleToLongBits(other.amount)
				&& author == other.author && Objects.equals(description, other.description)
				&& resolver == other.resolver;
	}
	@Override
	public String toString() {
		return "Reimbursement [ID=" + ID + ", author=" + author + ", resolver=" + resolver + ", description="
				+ description + ", amount=" + amount + "]";
	}
}
