package com.practice.forms.pages;

import com.practice.framework.utils.DriverUtils;

/**
 * 
 * @author Musthafa
 * Page class for drag and drop scenario
 */
public class DragAndDropPage extends DriverUtils {
	
	private static String siteUrl = "http://demoqa.com/droppable/";
	private static String elementToBeDraggedXpath = "//*[@id='draggableview']";
	private static String targetToBeDroppedXpath = "//*[@id='droppableview']";
	
	public void loadPage() {
		startPage(siteUrl);
	}
	
	public String getTextFromTarget() {
		String textFromTarget = "";
		if(isElementPresent(targetToBeDroppedXpath))
			textFromTarget= getText(targetToBeDroppedXpath, "Target location where element to be dropped");
		return textFromTarget;
	}
	
	public void dragAndDrop() {
		dragAndDrop(elementToBeDraggedXpath, targetToBeDroppedXpath, "Drag me to target Box", "Drop here box");
	}

}
