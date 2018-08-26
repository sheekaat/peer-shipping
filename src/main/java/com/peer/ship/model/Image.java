package com.peer.ship.model;

import java.io.InputStream;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Image {

	private String imageDesc;
	private Boolean frontCover;
	private InputStream in;
}
