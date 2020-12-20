package org.alex.model;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

public class Item {

    private Integer id;
    private BigDecimal total;
    private Set<Cart> carts = new HashSet<>();

    public Item() {
    }

    public Item(BigDecimal total) {
        this.total = total;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public Set<Cart> getCarts() {
        return carts;
    }

    public void setCarts(Set<Cart> carts) {
        this.carts = carts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Item item = (Item) o;

        if (id != null ? !id.equals(item.id) : item.id != null) return false;
        if (total != null ? !total.equals(item.total) : item.total != null) return false;
        return carts != null ? carts.equals(item.carts) : item.carts == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (total != null ? total.hashCode() : 0);
        result = 31 * result + (carts != null ? carts.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", total=" + total +
                ", cartSet=" + carts +
                '}';
    }
}
