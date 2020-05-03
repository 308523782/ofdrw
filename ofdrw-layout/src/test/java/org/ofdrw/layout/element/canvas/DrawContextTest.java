package org.ofdrw.layout.element.canvas;

import org.junit.jupiter.api.Test;
import org.ofdrw.layout.OFDDoc;
import org.ofdrw.layout.PageLayout;
import org.ofdrw.layout.VirtualPage;
import org.ofdrw.layout.edit.AdditionVPage;
import org.ofdrw.layout.element.Div;
import org.ofdrw.layout.element.Position;
import org.ofdrw.reader.OFDReader;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Canvas 测试
 *
 * @author 权观宇
 * @since 2020-05-02 18:25:25
 */
class DrawContextTest {


    @Test
    void stroke() throws IOException {
        Path outP = Paths.get("target/CanvasLineCreate.ofd");
        try (OFDDoc ofdDoc = new OFDDoc(outP)) {
            VirtualPage vPage = new VirtualPage(ofdDoc.getPageLayout());

            Canvas canvas = new Canvas(200d, 200d);
            canvas.setPosition(Position.Absolute)
                    .setX(5d).setY(45d)
                    .setBorder(1d);

            canvas.setDrawer(ctx -> {
                ctx.beginPath()
                        .moveTo(20, 20)
                        .lineTo(20, 100)
                        .lineTo(70, 100)
                        .setStrokeColor(0, 255, 0)
                        .stroke();
            });
            vPage.add(canvas);

            ofdDoc.addVPage(vPage);
        }
        System.out.println("生成文档位置：" + outP.toAbsolutePath().toString());
    }


    @Test
    void fill() throws IOException {
        Path outP = Paths.get("target/Canvas-fill.ofd");
        try (OFDDoc ofdDoc = new OFDDoc(outP)) {
            VirtualPage vPage = new VirtualPage(ofdDoc.getPageLayout());

            Canvas canvas = new Canvas(200d, 200d);
            canvas.setPosition(Position.Absolute)
                    .setX(5d).setY(45d)
                    .setBorder(1d);

            canvas.setDrawer(ctx -> {
                ctx.beginPath()
                        .moveTo(20, 20)
                        .lineTo(20, 100)
                        .lineTo(70, 100)
                        .closePath()
                        .setFillColor(255, 0, 0)
                        .stroke()
                        .fill();
            });
            vPage.add(canvas);

            ofdDoc.addVPage(vPage);
        }
        System.out.println("生成文档位置：" + outP.toAbsolutePath().toString());
    }

    @Test
    void beginPath() throws IOException {
        Path outP = Paths.get("target/Canvas-beginPath.ofd");
        try (OFDDoc ofdDoc = new OFDDoc(outP)) {
            VirtualPage vPage = new VirtualPage(ofdDoc.getPageLayout());

            Canvas canvas = new Canvas(200d, 200d);
            canvas.setPosition(Position.Absolute)
                    .setX(5d).setY(45d)
                    .setBorder(1d);

            canvas.setDrawer(ctx -> {
                ctx.beginPath();
                ctx.setLineWidth(3d);
                ctx.setStrokeColor(255, 0, 0);
                ctx.moveTo(0, 75);
                ctx.lineTo(150, 75);
                ctx.stroke();

                ctx.beginPath();
                ctx.setStrokeColor(0, 0, 255);
                ctx.moveTo(10, 0);
                ctx.lineTo(150, 130);
                ctx.stroke();
            });
            vPage.add(canvas);

            ofdDoc.addVPage(vPage);
        }
        System.out.println("生成文档位置：" + outP.toAbsolutePath().toString());
    }

    @Test
    void quadraticCurveTo() throws IOException {
        Path outP = Paths.get("target/Canvas-quadraticCurveTo.ofd");
        try (OFDDoc ofdDoc = new OFDDoc(outP)) {
            VirtualPage vPage = new VirtualPage(ofdDoc.getPageLayout());

            Canvas canvas = new Canvas(200d, 200d);
            canvas.setPosition(Position.Absolute)
                    .setX(5d).setY(45d)
                    .setBorder(1d);

            canvas.setDrawer(ctx -> {
                ctx.beginPath();
                ctx.moveTo(20, 20);
                ctx.quadraticCurveTo(20, 100, 200, 20);
                ctx.stroke();
            });
            vPage.add(canvas);

            ofdDoc.addVPage(vPage);
        }
        System.out.println("生成文档位置：" + outP.toAbsolutePath().toString());
    }

    @Test
    void bezierCurveTo() throws IOException {
        Path outP = Paths.get("target/Canvas-bezierCurveTo.ofd");
        try (OFDDoc ofdDoc = new OFDDoc(outP)) {
            VirtualPage vPage = new VirtualPage(ofdDoc.getPageLayout());

            Canvas canvas = new Canvas(200d, 200d);
            canvas.setPosition(Position.Absolute)
                    .setX(5d).setY(45d)
                    .setBorder(1d);

            canvas.setDrawer(ctx -> {
                ctx.beginPath();
                ctx.moveTo(20, 20);
                ctx.bezierCurveTo(20, 100, 200, 100, 200, 20);
                ctx.stroke();
            });
            vPage.add(canvas);

            ofdDoc.addVPage(vPage);
        }
        System.out.println("生成文档位置：" + outP.toAbsolutePath().toString());
    }

    @Test
    void arc() throws IOException {
        Path outP = Paths.get("target/Canvas-arc.ofd");
        try (OFDDoc ofdDoc = new OFDDoc(outP)) {
            VirtualPage vPage = new VirtualPage(ofdDoc.getPageLayout());

            Canvas canvas = new Canvas(200d, 200d);
            canvas.setPosition(Position.Absolute)
                    .setX(5d).setY(45d)
                    .setBorder(1d);

            canvas.setDrawer(ctx -> {
                ctx.beginPath();
                ctx.arc(100, 75, 50, 0, 360);
                ctx.stroke();
            });
            vPage.add(canvas);

            ofdDoc.addVPage(vPage);
        }
        System.out.println("生成文档位置：" + outP.toAbsolutePath().toString());
    }


    @Test
    void rect() throws IOException {
        Path outP = Paths.get("target/Canvas-rect.ofd");
        try (OFDDoc ofdDoc = new OFDDoc(outP)) {
            VirtualPage vPage = new VirtualPage(ofdDoc.getPageLayout());

            Canvas canvas = new Canvas(200d, 200d);
            canvas.setPosition(Position.Absolute)
                    .setX(5d).setY(45d)
                    .setBorder(1d);

            canvas.setDrawer(ctx -> {
                ctx.rect(20, 20, 150, 100);
                ctx.stroke();
            });
            vPage.add(canvas);

            ofdDoc.addVPage(vPage);
        }
        System.out.println("生成文档位置：" + outP.toAbsolutePath().toString());
    }

    @Test
    void strokeRect() throws IOException {
        Path outP = Paths.get("target/Canvas-strokeRect.ofd");
        try (OFDDoc ofdDoc = new OFDDoc(outP)) {
            VirtualPage vPage = new VirtualPage(ofdDoc.getPageLayout());

            Canvas canvas = new Canvas(200d, 200d);
            canvas.setPosition(Position.Absolute)
                    .setX(5d).setY(45d)
                    .setBorder(1d);

            canvas.setDrawer(ctx -> {
                ctx.strokeRect(20, 20, 150, 100);
            });
            vPage.add(canvas);

            ofdDoc.addVPage(vPage);
        }
        System.out.println("生成文档位置：" + outP.toAbsolutePath().toString());
    }

    @Test
    void fillRect() throws IOException {
        Path outP = Paths.get("target/Canvas-fillRect.ofd");
        try (OFDDoc ofdDoc = new OFDDoc(outP)) {
            VirtualPage vPage = new VirtualPage(ofdDoc.getPageLayout());

            Canvas canvas = new Canvas(200d, 200d);
            canvas.setPosition(Position.Absolute)
                    .setX(5d).setY(45d)
                    .setBorder(1d);

            canvas.setDrawer(ctx -> {
                ctx.fillRect(20, 20, 150, 100);
            });
            vPage.add(canvas);

            ofdDoc.addVPage(vPage);
        }
        System.out.println("生成文档位置：" + outP.toAbsolutePath().toString());
    }


    @Test
    void drawImage() throws IOException {
        Path outP = Paths.get("target/Canvas-drawImage.ofd");
        Path imgPath = Paths.get("src/test/resources/eg_tulip.jpg");
        try (OFDDoc ofdDoc = new OFDDoc(outP)) {
            VirtualPage vPage = new VirtualPage(ofdDoc.getPageLayout());

            Canvas canvas = new Canvas(200d, 200d);
            canvas.setPosition(Position.Absolute)
                    .setX(5d).setY(45d)
                    .setBorder(1d);

            canvas.setDrawer(ctx -> {
                ctx.drawImage(imgPath, 10, 10, 120, 80);
            });
            vPage.add(canvas);

            ofdDoc.addVPage(vPage);
        }
        System.out.println("生成文档位置：" + outP.toAbsolutePath().toString());
    }


    @Test
    void scale() throws IOException {
        Path outP = Paths.get("target/Canvas-scale.ofd");
        try (OFDDoc ofdDoc = new OFDDoc(outP)) {
            VirtualPage vPage = new VirtualPage(ofdDoc.getPageLayout());

            Canvas canvas = new Canvas(200d, 200d);
            canvas.setPosition(Position.Absolute)
                    .setX(5d).setY(45d)
                    .setBorder(1d);

            canvas.setDrawer(ctx -> {
                ctx.strokeRect(5,5,10,6);
                ctx.scale(2,2);
                ctx.strokeRect(5,5,10,6);
                ctx.scale(2,2);
                ctx.strokeRect(5,5,10,6);
                ctx.scale(2,2);
                ctx.strokeRect(5,5,10,6);
            });
            vPage.add(canvas);

            ofdDoc.addVPage(vPage);
        }
        System.out.println("生成文档位置：" + outP.toAbsolutePath().toString());
    }
}