package hufs.ces.grimpan.state;

import hufs.ces.grimpan.core.GrimPanModel;
import hufs.ces.grimpan.core.ShapeFactory;
import javafx.geometry.Point2D;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;

public class DeleteBuilderState implements EditState {

	ShapeFactory sf = null;	
	GrimPanModel model = null;
	
	public DeleteBuilderState(GrimPanModel model, ShapeFactory sf){
		this.model = model;
		this.sf = sf;
	}
	@Override
	public int getStateType() {
		return EditState.EDIT_DELETE;
	}
	@Override
	public void performMousePressed(MouseEvent event) {
		// TODO Auto-generated method stub
		Point2D p1 = new Point2D(Math.max(0, event.getX()), Math.max(0, event.getY()));
		
		model.setStartMousePosition(p1);
		model.setCurrMousePosition(p1);
		model.setPrevMousePosition(p1);		
		
		
		
		model.getSelectedShape();

	}

	@Override
	public void performMouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		if (model.getSelectedShapeIndex()!=-1) {
			
			int selIndex = model.getSelectedShapeIndex();
			Shape shape = null;
			if (selIndex != -1){
				shape = model.shapeList.get(selIndex);
				Color scolor = (Color)shape.getStroke();
				Color fcolor = (Color)shape.getFill();
				if (shape.getStroke()!=Color.TRANSPARENT){
					shape.setStroke(new Color (scolor.getRed(), scolor.getGreen(), scolor.getBlue(), 1));
				}
				if (shape.getFill()!=Color.TRANSPARENT){
					shape.setFill(new Color (fcolor.getRed(), fcolor.getGreen(), fcolor.getBlue(), 1));
				}
			
			}
//			
//			double dx = model.getCurrMousePosition().getX() - model.getStartMousePosition().getX();
//			double dy = model.getCurrMousePosition().getY() - model.getStartMousePosition().getY();
//			
//			System.out.println("dx"+dx);
//			System.out.println("dy"+dy);
//			model.setDeletedPos(new Point2D(dx,dy));
			
			model.DeleteShapeAction();
		}
		else {
			System.out.println("try again");
		}
		
		
	}

	@Override
	public void performMouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
