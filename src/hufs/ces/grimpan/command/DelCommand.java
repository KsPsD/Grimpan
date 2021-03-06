/**
 * Created on 2015. 4. 4.
 * @author cskim -- hufs.ac.kr, Dept of CSE
 * Copy Right -- Free for Educational Purpose
 */
package hufs.ces.grimpan.command;

import hufs.ces.grimpan.core.GrimPanModel;
import hufs.ces.grimpan.core.ShapeFactory;
import javafx.geometry.Point2D;
import javafx.scene.shape.Shape;

/**
 * @author cskim
 *
 */
public class DelCommand implements Command {

	GrimPanModel model = null;
	Shape deletedShape = null;
	Point2D delPos=null;
	int delIndex= 0;
	public DelCommand(GrimPanModel model){
		this.model = model;
		
	}
	@Override
	public void execute() {
		deletedShape = model.shapeList.get(model.getSelectedShapeIndex());
		delIndex = model.getSelectedShapeIndex();
		model.shapeList.remove(delIndex);
		
		
	}

	@Override
	public void undo() {
		
		System.out.println("undo");
		
		if (deletedShape != null){
			model.shapeList.add(deletedShape);
			ShapeFactory.translateShape(deletedShape, 0, 0);
			deletedShape = null;
		}
		
		// TODO Auto-generated method stub
		
	}

}
