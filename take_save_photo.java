String filePath;
private File chosenFile;
public final static int ACTIVITY_START_CAMERA_APP = 2001;


    public void fTakePhoto(View view){
        // Toast.makeText(this, getResources() .getString(R.string.toasttake), Toast.LENGTH_SHORT).show();
        Intent callCameraAplicationIntent = new Intent();
        callCameraAplicationIntent.setAction(MediaStore.ACTION_IMAGE_CAPTURE);
        //callCameraAplicationIntent.setType("video/*");
        File photoFile = null;
        try {
            photoFile = createImageFile();
        } catch (IOException e){
            e.printStackTrace();
        }
        callCameraAplicationIntent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(photoFile));
        startActivityForResult(callCameraAplicationIntent, ACTIVITY_START_CAMERA_APP);
    }



    File createImageFile() throws IOException {
        //String timestamp = new SimpleDateFormat("dd-MM-yyy").format(new Date());
        //String imageFileName = "Shoot_1";

        File storageDirectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
        //Para guardar imagenes en el directorio Pictures
        //File storageDirectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
        chosenFile = new File(storageDirectory, "Imageident");
        if (!chosenFile.exists()){
            chosenFile.mkdirs();
        }

        File image = new File(chosenFile, "IdentImage.jpg");
        filePath = image.getAbsolutePath();
        return image;

    }