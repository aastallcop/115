int sizeX = 810;
int sizeY = 410;
int strokeFloor = 10;
int strokeRoom = strokeFloor/2;

int fillGood, fillBad;
float actual1, actual2, potential1, potential2;

int floorX = strokeFloor/2;
int floorY = strokeFloor/2;
int floorW = sizeX - strokeFloor;
int floorH = sizeY - strokeFloor;

int stairsX = strokeFloor/2;
int stairsY = strokeFloor/2;
int stairsW = floorW * 0.08;
int stairsH = floorH * 0.5;

int trashX = stairsX + stairsW;
int trashY = stairsY;
int trashW = floorW * 0.10;
int trashH = floorH * 0.22;

int elecX = trashX;
int elecY = trashY + trashH;
int elecW = trashW * 0.9;
int elecH = floorH * 0.12;

int vestX = trashX;
int vestY = elecY + elecH;
int vestW = trashW * 1.1;
int vestH = floorH * 0.23;

int kitchenX = trashX;
int kitchenY = vestY + vestH;
int kitchenW = vestW;
int kitchenH = floorH * 0.20;

int prepX = trashX;
int prepY = kitchenY + kitchenH;
int prepW = vestW;
int prepH = floorH * 0.23;

int staffPeeX = trashX + trashW;
int staffPeeY = trashY;
int staffPeeW = stairsW;
int staffPeeH = trashH;

int classRoomX = vestX + vestW;
int classRoomY = vestY + vestH * 0.5;
int classRoomW = floorW * 0.5 - stairsW - vestW;
int classRoomH = floorH - classRoomY + strokeRoom;

int office111X = (floorW * 0.5 - ((1 - ((floorW * 0.5 - (stairsW + trashW + staffPeeW))/classRoomW)) * classRoomW));
int office111Y = trashY;
int office111W = trashW;
int office111H = trashH;

int openOfficeX = elecX + elecW;
int openOfficeY = trashY;
int openOfficeW = office111X + office111W - elecW - stairsW;
int openOfficeH = floorH * 0.5;

int tankX = office111X + office111W;
int tankY = office111Y;
int tankW = office111W;
int tankH = trashH + elecH;

int pumpX = tankX + tankW;
int pumpY = tankY;
int pumpW = tankW * 0.7;
int pumpH = tankH;

int elevX = pumpX + pumpW;
int elevY = pumpH * 0.4;
int elevW = pumpW;
int elevH = pumpH - elevY + strokeRoom;

int womenPeeX = floorW * 0.5 + strokeRoom;
int womenPeeY = kitchenY + kitchenW * 0.1;
int womenPeeW = (elevX + elevW - stairsW - prepW - classRoomW)/3;
int womenPeeH = floorH - womenPeeY + strokeRoom;

int menPeeX = womenPeeX + womenPeeW;
int menPeeY = womenPeeY;
int menPeeW = womenPeeW;
int menPeeH = womenPeeH;

int officeX = menPeeX + menPeeW;
int officeY = menPeeY + menPeeH * 0.5;
int officeW = elevX + elevW - stairsW - prepW - classRoomW - womenPeeW -menPeeW - strokeRoom;
int officeH = menPeeH * 0.5;

int storageX = pumpX;
int storageY = classRoomY;
int storageW = pumpW + elevW;
int storageH = classRoomH/2;

lobby1X = elevX;
lobby1Y = pumpY;
lobby1W = floorW - stairsW - elecW - openOfficeW - tankW - pumpW + strokeRoom;
lobby1H = floorH;

int lobby2X = floorW * 0.5 + strokeRoom;
int lobby2Y = vestY;
int lobby2W = floorW * 0.5;
int lobby2H = floorH - vestY - trashY + strokeFloor;


void setup() {
  size(1000, 600);
  PFont fontA = loadFont("courier");
  textFont(fontA, 14);  
  rectMode(CORNER);
  noLoop();
}

void draw() {
    importData();
    drawFloor();
}

void importData() {
    String lines[] = loadStrings("heatingRate.txt");
    actual1 = lines[1];
    potential1 = lines[2];
    actual2 = lines[3];
    potential2 = lines[4]

}

void drawFloor() {
    //floor
    stroke(0);
    strokeWeight(strokeFloor);
    fill(125);
    rect(floorX, floorY, floorW, floorH);

    //stairs
    strokeWeight(strokeRoom);
    fill(255);
    rect(stairsX, stairsY, stairsW, stairsH);

    //openOffice
    fill(255);
    rect(openOfficeX, openOfficeY, openOfficeW, openOfficeH);

    //lobby2
    fill(255);
    stroke(0);
    rect(lobby2X, lobby2Y, lobby2W, lobby2H);

    //lobby1
    stroke(0, 0);
    fill(255);
    rect(lobby1X, lobby1Y, lobby1W, lobby1H);

    //trash room
    stroke(0);
    fill(255);
    rect(trashX, trashY, trashW, trashH);

    //electrical room
    fill(255);
    rect(elecX, elecY, elecW, elecH);

    //vestibule
    fill(255);
    rect(vestX, vestY, vestW, vestH);

    //kitchen
    fill(255);
    rect(kitchenX, kitchenY, kitchenW, kitchenH);

    //prep room
    fill(255);
    rect(prepX, prepY, prepW, prepH);

    //staff restroom
    fill(255);
    rect(staffPeeX, staffPeeY, staffPeeW, staffPeeH);

    //classRoom
    fillGood = int(255 * (actual1/potential1));
    fillBad = int(255 * (1 - actual1/potential1));
    fill(fillBad, fillGood, 0);
    rect(classRoomX, classRoomY, classRoomW, classRoomH);
    fill(255, 255, 0);
    text ("Classroom", classRoomX, classRoomY, classRoomW, classRoomH);

    //office111
    fill(255);
    rect(office111X, office111Y, office111W, office111H);


    //tank
    fill(255);
    rect(tankX, tankY, tankW, tankH);

    //pump room
    fill(255);
    rect(pumpX, pumpY, pumpW, pumpH);

    //elevator
    fill(255);
    rect(elevX, elevY, elevW, elevH);

    //storage
    fill(255);
    rect(storageX, storageY, storageW, storageH);

    //women's restroom
    fillGood = int(255 * (actual2/potential2));
    fillBad = int(255 * (1 - actual2/potential2));
    fill(fillBad, fillGood, 0);
    rect(womenPeeX, womenPeeY, womenPeeW, womenPeeH);
    fill(255, 0, 255);
    text ("Women's Restroom", womenPeeX, womenPeeY + womenPeeH * 0.1, womenPeeW, womenPeeH);

    //men's restroom
    fillGood = int(255 * (actual2/potential2));
    fillBad = int(255 * (1 - actual2/potential2));
    fill(fillBad, fillGood, 0);
    rect(menPeeX, menPeeY, menPeeW, menPeeH);
    fill(255, 0, 255);
    text ("Men's Restroom", menPeeX, menPeeY + menPeeH * 0.5, menPeeW, menPeeH);

    //office
    fill(255);
    rect(officeX, officeY, officeW, officeH);

    //draw bar
    int actualBar = 0;
    int potentialBar = 100;
    int inc = stairsH/11;
    for(int i=0; i<11; i++) {
        int barGood = int(255 * (actualBar/potentialBar));
        int barBad = int(255 * (1 - actualBar/potentialBar));
        fill (barBad, barGood, 0);
        rect(stairsX, stairsY + stairsH + (inc * i), stairsW, stairsH/11);
        actualBar += 10;
    }

}


