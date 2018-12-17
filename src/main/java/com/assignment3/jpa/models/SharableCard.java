package com.assignment3.jpa.models;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.io.Serializable;

@Entity
@DiscriminatorValue(value = "SH")
public class SharableCard extends Card implements Serializable {
}
