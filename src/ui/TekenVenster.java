package ui;

import java.awt.BasicStroke;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JOptionPane;

import domain.Tekenbaar;
import domain.Tekening;

public class TekenVenster extends Canvas {

	private static final long serialVersionUID = 1L;
	private Tekening tekening = null;

	public TekenVenster(Tekening tekening) {
		this.setPreferredSize(new Dimension(400, 400));
		setTekening(tekening);
	}

	private void setTekening(Tekening tekening) {
		if (tekening == null)
			throw new UiException("Tekening mag niet null zijn");
		this.tekening = tekening;
	}

	public void teken() {
		repaint();
	}

	@Override
	public void paint(Graphics graphics) {
		Graphics2D graphics2D = (Graphics2D) graphics;
		graphics2D.setStroke(new BasicStroke(5));

		for (int i = 0; i < this.tekening.getAantalVormen(); i++) {
			if (this.tekening.getVorm(i).isZichtbaar()) {
				try {
					Tekenbaar tek = (Tekenbaar) this.tekening.getVorm(i);
					tek.teken(graphics);
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
				}
			}
		}

	}
}
