package com.monika.smartreaders.MainUI;

 /*  String collectionPath="Books/"+info+"/"+year;
        Log.d(TAG, "onCreate: "+collectionPath);

        db.collection(collectionPath).get()
                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                        Log.d(TAG, "onSuccess: im first");
                        List<DocumentSnapshot> list = queryDocumentSnapshots.getDocuments();
                        for (DocumentSnapshot d : list) {
                            BookDisplay obj = d.toObject(BookDisplay.class);
                            obj.setbookPath(d.getReference().getPath());
                            obj.setBookID(d.getId());
                            mdata.add(obj);
                        }
                        //update Adapter

                        docRef.addSnapshotListener(new EventListener<DocumentSnapshot>() {
                            @Override
                            public void onEvent(DocumentSnapshot snapshot,
                                                FirebaseFirestoreException e) {
                                if (e != null) {
                                    Log.w(TAG, "Listen failed.", e);
                                    return;
                                }

                                if (snapshot != null && snapshot.exists()) {
                                    Map<String, Object> data = snapshot.getData();

                                    for (Map.Entry obj : data.entrySet()) {
                                        BookDisplay book = getBook((String) obj.getKey());
                                        Log.d(TAG, "onEvent: " + obj.getKey());

                                        if (book != null) {
                                            book.setFav(true);
                                            Log.d(TAG, "onEvent: " + book.getBookID() + " " + book.isFav());
                                        }
                                    }
                                } else {
                                    Log.d(TAG, "Current data: null");
                                }
                                bookAdapter.notifyDataSetChanged();

                            }

                        });

                    }
                });


*/

//TO- DO
/*
 * 1. Complete wishlist part.                               done
 * 2. With that soon complete all 3 adapters asap           done
 * 3. UI for displaying all branches and their categories   done
 * 4. Systemize your data
 * 5. Customize your pdf viewer with webview                done
 * 6. Disconnect your firebase and connect to theirs firebase   done.
to stop ss and screen sharing
* getWindow().setFlags(WindowManager.LayoutParams.FLAG_SECURE, WindowManager.LayoutParams.FLAG_SECURE);

*/

 /* pdfVIEW=(PDFView) findViewById(R.id.viewpdf);
        String filename= getIntent().getStringExtra("filename");
        pdfVIEW.fromAsset(filename)
                .pages(0, 2, 1, 3, 3, 3) // all pages are displayed by default
                .enableSwipe(true) // allows to block changing pages using swipe
                .swipeHorizontal(false)
                .enableDoubletap(true)
                .defaultPage(0)
                .spacing(0)
                .load();*/







 /* File rootDataDir = holder.title.getContext().getFilesDir();
                String Datadir=rootDataDir.toString();
                System.out.println(Datadir);
*/
//String FilePath=downloadFile(holder.title.getContext(),mdata.get(position).getTitle(),".pdf",Datadir,mdata.get(position).getbUri());


/* public BookAdapter(@NonNull  FirestoreRecyclerOptions<BookDisplay> options) {
        super(options);
    }
*/
/*
    @Override
    protected void onBindViewHolder(@NonNull BookAdapter.bookviewholder holder, int position, @NonNull BookDisplay model) {

        holder.title.setText(model.getTitle());
        holder.description.setText(model.getDescription());
        holder.nop.setText(String.valueOf(model.getNop()));
        holder.nov.setText(String.valueOf(model.getNov()));
        //holder.imgbook.setImageDrawable(Drawable.createFromPath(model.getCover()));
            holder.imgbook.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(holder.imgbook.getContext(),);
                }
            });

    }*/
/*

    public String downloadFile(Context context, String fileName, String fileExtension, String destinationDirectory, String url) {

        DownloadManager downloadmanager = (DownloadManager) context.
                getSystemService(Context.DOWNLOAD_SERVICE);
        Uri uri = Uri.parse(url);
        DownloadManager.Request request = new DownloadManager.Request(uri);

        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
        request.setDestinationInExternalFilesDir(context, destinationDirectory, fileName + fileExtension);

        downloadmanager.enqueue(request);
        return fileName + fileExtension;
    }
    public static Drawable LoadImageFromWebOperations(String url) {
        try {
            InputStream is = (InputStream) new URL(url).getContent();
            Drawable d = Drawable.createFromStream(is, "src name");
            return d;
        } catch (Exception e) {
            return null;
        }
    }

*/


//BookDisplay book = getBook((String) obj.getValue());
//BookDisplay obj = d.toObject(BookDisplay.class);
                        /*if (book != null) {
                            newData.add(book);
                        }*/


//Home.java implemented using methods

/*initViews();
initdataBooks();
setuUpBookAdapter();*/

/*private void setuUpBookAdapter() {
    bookAdapter = new BookAdapter(mdata);
    rvBooks.setAdapter(bookAdapter);
}

private void initdataBooks() {
    mdata= new ArrayList<>();
    mdata.add(new BookDisplay(R.drawable.b1));
    mdata.add(new BookDisplay(R.drawable.b2));
    mdata.add(new BookDisplay(R.drawable.b3));
    mdata.add(new BookDisplay(R.drawable.b4));
}

private void initViews() {
    rvBooks=findViewById(R.id.rv_book);
    rvBooks.setLayoutManager(new LinearLayoutManager(this));
    rvBooks.setHasFixedSize(true);
}*/

/*import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;*/
/*

public class trialdumpcode extends FirestoreRecyclerAdapter<BookDisplay,BookAdapter.bookviewholder> {

    List<BookDisplay> mdata;

    public BookAdapter(@NonNull  FirestoreRecyclerOptions<BookDisplay> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull BookAdapter.bookviewholder holder, int position, @NonNull BookDisplay model) {
        holder.author.setText();
        holder.title.setText(model.getTitle());
        holder.description.setText(model.getDescription());
        holder.nop.setText(String.valueOf(model.getNop()));
        holder.nov.setText(String.valueOf(model.getNov()));
        //holder.imgbook.setImageDrawable(Drawable.createFromPath(model.getCover()));
        holder.imgbook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(holder.imgbook.getContext(),);
            }
        });

    }


    @NonNull
    @Override
    public bookviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.dashboard,parent,false);
        return new bookviewholder(view);
    }

    */
/*@Override
    public void onBindViewHolder(@NonNull  BookAdapter.bookviewholder holder, int position) {
        //bind book and all necessary data here
       *//*
 */
/* Glide.with(holder.itemView.getContext())
                .load(mdata.get(position).getDrawableResource())
                .transform(new CenterCrop(),new RoundedCorners(16))
                .into(holder.imgbook);*//*
 */
/*
    }*//*



    public class bookviewholder extends RecyclerView.ViewHolder{
        ImageView imgbook,imgfav;
        TextView title,description,author,nop,nov;
        RatingBar ratingBar;

        public bookviewholder(@NonNull View itemView) {
            super(itemView);
            imgbook=itemView.findViewById(R.id.bimg);
            title=itemView.findViewById(R.id.btitle);
            description=itemView.findViewById(R.id.description);
            imgfav=itemView.findViewById(R.id.fav);
            author=itemView.findViewById(R.id.bauthor);
            nop=itemView.findViewById(R.id.nop);
            nov=itemView.findViewById(R.id.views);
        }
    }
}
*/

//---------------
//SIGNuPTabFragment
//---------------
//Checking whether phone number already exists!!
        /*Query checkphoneUser = FirebaseDatabase.getInstance().getReference("Users").orderByChild("phonenum").equalTo(phoneNoformat);
        checkphoneUser.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull  DataSnapshot snapshot) {
                if(snapshot.exists()){
                    phoneno.requestFocus();
                    phoneno.setError("User with this Phone number already exists!!");
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });*/

        /*//Checking whether username already taken
        Query checkUser =FirebaseDatabase.getInstance().getReference("Users").orderByChild("username").equalTo(Username);
        checkUser.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()){
                    username.requestFocus();
                    username.setError("Username is taken!");
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(),error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });*/

/*com.google.firebase.firestore.Query checkIng = db.collection("Users").whereEqualTo("phonenum", phoneNoformat);
        System.out.println("print"+checkIng);*/
        /*checkIng.get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull  Task<QuerySnapshot> task) {
               if(task.isSuccessful()){
                   for (QueryDocumentSnapshot document : task.getResult()) {
                       System.out.println("impringitn"+document.getId() + " => " + document.getData());
                   }
               }
            }
        });*/
/*

                    phoneno.requestFocus();
                    phoneno.setError("User with this Phone number already exists!!");
*/
/*

Query checkUser = FirebaseDatabase.getInstance().getReference("Users").orderByChild("phonenum").equalTo(phoneNoformat);
        checkUser.addListenerForSingleValueEvent(new ValueEventListener() {
@Override
public void onDataChange(@NonNull DataSnapshot snapshot) {
        if(snapshot.exists()){
        phoneno.setError(null);
        String clasfrom="Login";
        */
/*String systemPassword = snapshot.child(phoneNoformat).child("password").getValue(String.class);*//*

        String Name=snapshot.child(phoneNoformat).child("name").getValue(String.class);
        String username=snapshot.child(phoneNoformat).child("username").getValue(String.class);
        intent.putExtra("name",Name);
        intent.putExtra("username",username);
        intent.putExtra("clasfrom",clasfrom);
        startActivity(intent);
        }
        else{
        Toast.makeText(getContext(), "No such user exists!!", Toast.LENGTH_SHORT).show();
        }
        }

@Override
public void onCancelled(@NonNull DatabaseError error) {

        }
        });*/

/*

    private RecyclerView rvwish;
    private WishListAdapter wishAdapter;
    private List<BookDisplay> newData;
    private static final String TAG = "Favourite";
    StorageReference storageReference;
    DatabaseReference databaseReference;
    //private FirebaseAuth mAuth=FirebaseAuth.getInstance();
    //FirebaseFirestore firebaseFirestore=FirebaseFirestore.getInstance();
    //private DocumentReference docRef= firebaseFirestore.collection("USERS").document(mAuth.getUid()).collection("USER_DATA").document("MY_FAVOURITES");

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.activity_favourite,container,false);
        storageReference= FirebaseStorage.getInstance().getReference();
        databaseReference= FirebaseDatabase.getInstance().getReference("books");
        newData= new ArrayList<>();
        FirebaseFirestore db = FirebaseFirestore.getInstance();

        rvwish=root.findViewById(R.id.wishlistview);
        rvwish.setLayoutManager(new LinearLayoutManager(getActivity()));
        wishAdapter= new WishListAdapter(newData);
        rvwish.setAdapter(wishAdapter);
        rvwish.setHasFixedSize(true);

        db.collection("books").get()
                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                        List<DocumentSnapshot> list = queryDocumentSnapshots.getDocuments();
                        for(DocumentSnapshot d:list){
                            BookDisplay obj= d.toObject(BookDisplay.class);
                            obj.setbookPath(d.getReference().getPath());
                            obj.setBookID(d.getId());
                            newData.add(obj);
                        }
                        //update Adapter
                        wishAdapter.notifyDataSetChanged();
                    }
                });


        return root;
    }*/


//Main dashboard top rated code
/*

private void toprated() {
        toprated.setLayoutManager(new LinearLayoutManager(this));
        topAdapter = new topRatedAdapter();
        toprated.setAdapter(topAdapter);
        toprated.setHasFixedSize(true);

        db.collection("books").get()
        .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
@Override
public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
        List<DocumentSnapshot> list = queryDocumentSnapshots.getDocuments();
        for(DocumentSnapshot d:list){
        topRatedRecords obj= d.toObject(topRatedRecords.class);
        topRatedRecordsList.add(obj);


        }
        //update Adapter
        topAdapter.notifyDataSetChanged();
        }
        });

        }
*/

//LOGINACTICYT
/*

package com.monika.bookfriendly;

import android.content.Context;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;


public class LoginAdapter extends FragmentStateAdapter {
    private Context context;
    int TotalTabs=2;

    public LoginAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    */
/*@Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0:
                return new SignUpTabFragment();
            case 1:
                return new LoginTabFragment();
            default:
                return null;
        }

    }*//*



    @Override
    public int getItemCount() {
        return TotalTabs;
    }

}


*/
