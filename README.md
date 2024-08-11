# Converter to text graphics.

An application that downloads images from a URL and converts the image into text graphics (that is, text made up of different characters that together look like an image). Here is an example of his work. The picture on it is text made up of small characters:
<img width="811" alt="Screenshot 2024-08-11 at 11 53 34" src="https://github.com/user-attachments/assets/e69de0cd-dfd7-4a19-83aa-41a98cd38800">


## Project structure:

| Class / Interface      | For what purpose? |
| ----------- | ----------- |
| `BadImageSizeException`      | Exception class       |
| `TextColorSchema`   | Color scheme interface        |
| `TextGraphicsConverter`   | Image converter interface        |
| `GServer`   | Ready server class        |
| `Main`   | Launch the application. The server runs in it.        |


## The general scheme of work will correspond to the sequence of actions:

1. Download the image from the URL.
2. They can set the maximum allowable aspect ratio (width and height); if it is too large, then no conversion is done and an exception is thrown.
3. When converting, we will change each pixel to a character: the darker the pixel, the bolder the character that we will substitute. We could set the maximum width and height of the final image, but if the original image is larger, then we need to reduce its size, respecting the proportions.
4. We convert a color image into black and white so that we look only at the intensity of the color, and do not select some symbols for red, others for green, etc.
1. We go through all the pixels in the image, asking them for their degree of white (a number from 0 to 255, where 0 is black and 255 is light). Depending on this number, we select a symbol from a pre-prepared set.
1. We collect all the received characters into a single string and return them as the result of the conversion.


## Color scheme requirements:

The following logic of its operation is proposed. Here is a list of characters from darkest to lightest: '▇', '●', '◉', '◍', '◎', '○', '☉', '◌', '-'. If we are programming on Windows, it is better to use another list of more standard symbols, otherwise it may be drawn crookedly: '#', '$', '@', '%', '*', '+', '-', '\''.
Depending on the transmitted white intensity value, the appropriate symbol must be selected. For example, if the value is close to 0, then select '▇'; if to 255, then '-'. If it’s somewhere in the middle, then you have to choose somewhere in the middle too.

* Image for demonstration: [https://i.ibb.co/6DYM05G/edu0.jpg](https://i.ibb.co/xqLnF6V/2023-10-23-17-47-49.png)