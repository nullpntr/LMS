/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package nita.project.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import nita.project.objects.Author;
import nita.project.objects.AuthorBook;
import nita.project.objects.Book;
import nita.project.objects.BookIndividual;
import nita.project.objects.Branch;
import nita.project.objects.Publication;

public class BookDB {

    private PreparedStatement ps;
    private ResultSet rs, rs2, rs3;
    private Connection c;

    public boolean save(String b_title, String pub, int price, int ed, String a1, String a2, String a3, String br) {
        try {
            c = new CommonDB().getConnection();
            String q = "insert into book_master(book_title, book_author_id1, book_author_id2, "
                    + "book_author_id3, book_pub_id, book_price, book_edition, book_br_id) values(?,(select author_id"
                    + " from author_master where author_name = ?),(select author_id from author_master where"
                    + " author_name = ?),(select author_id from author_master where author_name = ?),(select pub_id"
                    + " from publication_master where pub_name = ?),?,?,(select br_id from branch_master where br_name"
                    + " = ?))";
            ps = c.prepareStatement(q);
            System.out.println(q);
            ps.setString(1, b_title);
            ps.setString(2, a1);
            ps.setString(3, a2);
            ps.setString(4, a3);
            ps.setString(5, pub);
            ps.setInt(6, price);
            ps.setInt(7, ed);
            ps.setString(8, br);
            ps.executeUpdate();
            ps.close();
            c.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public ArrayList<AuthorBook> search(String criteria) {
        try {
            c = new CommonDB().getConnection();
            String q = "select book_master.book_title, book_master.book_price, branch_master.br_name, author_master.author_name, book_individual.rack_no, book_individual.book_acc_no from "
                    + "book_individual, book_master, author_master, branch_master where author_master.author_id = book_master.book_author_id1 and "
                    + " book_master.book_br_id = branch_master.br_id and book_master.book_id = book_individual.book_id" + criteria;
            System.out.println(q);
            ps = c.prepareStatement(q);
            rs = ps.executeQuery();
            ArrayList<AuthorBook> dd = new ArrayList<AuthorBook>();
            while (rs.next()) {
                AuthorBook ab = new AuthorBook();
                Book bk = new Book();
                Author au = new Author();
                Branch br = new Branch();
                BookIndividual bi = new BookIndividual();
                bk.setTitle(rs.getString(1));
                bk.setBkPrice(rs.getInt(2));
                br.setBrName(rs.getString(3));
                au.setAuName(rs.getString(4));
                bi.setRackNo(rs.getString(5));
                bi.setAccNo(rs.getString(6));
                ab.setBook(bk);
                ab.setAuthor(au);
                ab.setBranch(br);
                ab.setBi(bi);
                dd.add(ab);

            }
            rs.close();
            ps.close();
            c.close();
            return dd;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    public ArrayList<AuthorBook> searchMaster(String criteria) {
        try {
            c = new CommonDB().getConnection();
            String q = "select book_master.book_title, book_master.book_price, branch_master.br_name, author_master.author_name, book_master.book_id from "
                    + "book_master, author_master, branch_master where author_master.author_id = book_master.book_author_id1 and "
                    + " book_master.book_br_id = branch_master.br_id" + criteria;
            System.out.println(q);
            ps = c.prepareStatement(q);
            rs = ps.executeQuery();
            ArrayList<AuthorBook> dd = new ArrayList<AuthorBook>();
            while (rs.next()) {
                AuthorBook ab = new AuthorBook();
                Book bk = new Book();
                Author au = new Author();
                Branch br = new Branch();
                BookIndividual bi = new BookIndividual();
                bk.setTitle(rs.getString(1));
                bk.setBkPrice(rs.getInt(2));
                br.setBrName(rs.getString(3));
                au.setAuName(rs.getString(4));
                bk.setBkId(rs.getInt(5));
                ab.setBook(bk);
                ab.setAuthor(au);
                ab.setBranch(br);
                ab.setBi(bi);
                dd.add(ab);

            }
            rs.close();
            ps.close();
            c.close();
            return dd;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<String> getBranchs() {
        try {
            c = new CommonDB().getConnection();
            ps = c.prepareStatement("select br_name from branch_master");
            rs = ps.executeQuery();
            ArrayList<String> bn = new ArrayList<String>();
            while (rs.next()) {
                Branch br = new Branch();

                br.setBrName(rs.getString(1));
                bn.add(br.getBrName());

            }
            rs.close();
            ps.close();
            c.close();
            return bn;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<String> getAuthors() {
        try {
            c = new CommonDB().getConnection();
            ps = c.prepareStatement("select author_name from author_master");
            rs = ps.executeQuery();
            ArrayList<String> an = new ArrayList<String>();
            while (rs.next()) {
                Author a = new Author();

                a.setAuName(rs.getString(1));
                an.add(a.getAuName());

            }
            rs.close();
            ps.close();
            c.close();

            return an;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

     public ArrayList<String> getPublications() {
        try {
            c = new CommonDB().getConnection();
            ps = c.prepareStatement("select pub_name from publication_master");
            rs = ps.executeQuery();
            ArrayList<String> an = new ArrayList<String>();
            while (rs.next()) {
                Publication a = new Publication();

                a.setPubName(rs.getString(1));
                an.add(a.getPubName());

            }
            rs.close();
            ps.close();
            c.close();
            return an;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<String> getTitles(){
        try {
            c = new CommonDB().getConnection();
            ps = c.prepareStatement("select book_title from book_master order by book_id");
            rs = ps.executeQuery();
            ArrayList<String> an = new ArrayList<String>();
            while (rs.next()) {
                Book a = new Book();

                a.setTitle(rs.getString(1));
                an.add(a.getTitle());

            }
            rs.close();
            ps.close();
            c.close();
            return an;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

     public boolean saveBranch(String brName) {
        try {
            c = new CommonDB().getConnection();
            ps = c.prepareStatement("insert into branch_master(br_name) values(?)");
            ps.setString(1, brName);
            ps.executeUpdate();
            ps.close();
            c.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean saveAuthor(String auName) {
        try {
            c = new CommonDB().getConnection();
            ps = c.prepareStatement("insert into author_master(author_name) values(?)");
            ps.setString(1, auName);
            ps.executeUpdate();
            ps.close();
            c.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean savePublication(String pbName) {
        try {
            c = new CommonDB().getConnection();
            ps = c.prepareStatement("insert into publication_master(pub_name) values(?)");
            ps.setString(1, pbName);
            ps.executeUpdate();
            ps.close();
            c.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean delBookMaster(Object id) {
        try {
            c = new CommonDB().getConnection();
            String q = "delete from book_master where book_id='" + id + "'";
            ps = c.prepareStatement(q);
            System.out.println(q);
            ps.execute();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean delBook(String i) {
        try {
            c = new CommonDB().getConnection();
            String q = "delete from book_individual where book_acc_no='" + i + "'";
            ps = c.prepareStatement(q);
            System.out.println(q);
            ps.execute();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public ArrayList<String> getBookAccNos() {
        try {
            c = new CommonDB().getConnection();
            ps = c.prepareStatement("select book_acc_no from book_individual");
            rs = ps.executeQuery();
            ArrayList<String> an = new ArrayList<String>();
            while (rs.next()) {
                BookIndividual a = new BookIndividual();

                a.setAccNo(rs.getString(1));
                an.add(a.getAccNo());

            }
            rs.close();
            ps.close();
            c.close();
            return an;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

     public ArrayList<String> getBookAccNo() {
        try {
            c = new CommonDB().getConnection();
            ps = c.prepareStatement("select book_acc_no from book_individual");
            rs = ps.executeQuery();
            ArrayList<String> an = new ArrayList<String>();
            while (rs.next()) {
                BookIndividual a = new BookIndividual();

                a.setAccNo(rs.getString(1));
                an.add(a.getAccNo());

            }
            rs.close();
            ps.close();
            c.close();
            return an;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean delBranch(String s) {

        try {
            c = new CommonDB().getConnection();
            ps = c.prepareStatement("delete from branch_master where br_name='" + s + "'");
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public ArrayList<BookIndividual> getReservedStd(String i) {
        try {
            c = new CommonDB().getConnection();
            String smt = "select book_master.book_title,book_individual.book_acc_no,author_master.author_name from "
                    + "book_master,book_individual,author_master where book_master.book_author_id1=author_master.author_id and "
                    + "book_master.book_id=book_individual.book_id and book_individual.holder_id='" + i + "' and book_individual.avail_flag_id = '3'";
            System.out.println(smt);
            ps = c.prepareStatement(smt);
            rs = ps.executeQuery();
            ArrayList<BookIndividual> dd = new ArrayList<BookIndividual>();
            while (rs.next()) {
                BookIndividual ab = new BookIndividual();

                ab.setBookName(rs.getString(1));
                ab.setAccNo(rs.getString(2));
                ab.setAuthorName(rs.getString(3));
                dd.add(ab);
            }
            rs.close();
            ps.close();
            c.close();
            return dd;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<BookIndividual> getIssuedStd(String i) {
        try {
            c = new CommonDB().getConnection();
            String smt = "select book_master.book_title,book_individual.book_acc_no,author_master.author_name from "
                    + "book_master,book_individual,author_master where book_master.book_author_id1=author_master.author_id and "
                    + "book_master.book_id=book_individual.book_id and book_individual.holder_id='" + i + "' and book_individual.avail_flag_id = '2'";
            System.out.println(smt);
            ps = c.prepareStatement(smt);
            rs = ps.executeQuery();
            ArrayList<BookIndividual> dd = new ArrayList<BookIndividual>();
            while (rs.next()) {
                BookIndividual ab = new BookIndividual();

                ab.setBookName(rs.getString(1));
                ab.setAccNo(rs.getString(2));
                ab.setAuthorName(rs.getString(3));
                dd.add(ab);
            }
            rs.close();
            ps.close();
            c.close();
            return dd;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<BookIndividual> searchFac(int i) {
        try {
            c = new CommonDB().getConnection();
            String smt = "select book_master.book_title,book_individual.book_acc_no,author_master.author_name from "
                    + "book_master,book_individual,author_master where book_master.book_author_id1=author_master.author_id and "
                    + "book_master.book_id=book_individual.book_id and book_individual.holder_id='" + i + "'";
            System.out.println(smt);
            ps = c.prepareStatement(smt);
            rs = ps.executeQuery();
            ArrayList<BookIndividual> dd = new ArrayList<BookIndividual>();
            while (rs.next()) {
                BookIndividual ab = new BookIndividual();

                ab.setBookName(rs.getString(1));
                ab.setAccNo(rs.getString(2));
                ab.setAuthorName(rs.getString(3));
                dd.add(ab);
            }
            rs.close();
            ps.close();
            c.close();
            return dd;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean reserveBook(String accNo, String hid, String ht) {
        try {
            c = new CommonDB().getConnection();
            String q = "update book_individual set avail_flag_id = '3', holder_id = '"+hid+"' , "
                    + " holder_type = '"+ht+"' where book_acc_no = '" + accNo + "' ";
            ps = c.prepareStatement(q);
            System.out.println(q);
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean issueBook(String accNo, String hid, String ht) {
        try {
            c = new CommonDB().getConnection();
            ps = c.prepareStatement("update book_individual set avail_flag_id = '2', holder_id = '"+hid+"' , "
                    + " holder_type = '"+ht+"' where book_acc_no = '" + accNo + "' ");
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean returnBook(String accNo) {
        try {
            c = new CommonDB().getConnection();
            String q = "update book_individual set avail_flag_id = '1' , holder_type = 'N' , holder_id = 'N' where book_acc_no = '" + accNo + "' ";
            ps = c.prepareStatement(q);
            System.out.println(q);
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


    public boolean saveAccNo(String title,String acc,String rack,int flag){
        try {
            c = new CommonDB().getConnection();
            ps = c.prepareStatement("insert into book_individual(book_id, book_acc_no, rack_no, avail_flag_id) values((select book_id from book_master where book_title = ?),?,?,?)");
            ps.setString(1, title);
            ps.setString(2, acc);
            ps.setString(3, rack);
            ps.setInt(4, flag);
            ps.executeUpdate();
            ps.close();
            c.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    public ArrayList<BookIndividual> searchIndiBook(String i) {
        try {
            c = new CommonDB().getConnection();
            ps = c.prepareStatement("select book_master.book_title,book_master.book_price, author_master.author_name,availability_flag_master.flag,book_individual.holder_type, book_individual.holder_id from (book_master,book_individual,author_master,availability_flag_master) where book_master.book_id=book_individual.book_id and book_master.book_author_id1=author_master.author_id and availability_flag_master.flag_id=book_individual.avail_flag_id and book_individual.book_acc_no='" + i + "'");
            rs = ps.executeQuery();
            ArrayList<BookIndividual> dd = new ArrayList<BookIndividual>();
            while (rs.next()) {
                BookIndividual bk = new BookIndividual();

                bk.setBookName(rs.getString(1));
                bk.setBookPrice(rs.getInt(2));
                bk.setAuthorName(rs.getString(3));
                bk.setFlag(rs.getString(4));
                bk.setHolderType(rs.getString(5));
                bk.setHolderId(rs.getString(6));
                dd.add(bk);

            }
            return dd;
        } catch (Exception e) {
            return null;

        }

    }


    public ArrayList<String> checkBookAccNum() {
        try {
            c = new CommonDB().getConnection();
            ps = c.prepareStatement("select book_acc_no from book_individual");
            rs = ps.executeQuery();
            ArrayList<String> dd = new ArrayList<String>();
            while (rs.next()) {
                BookIndividual ab = new BookIndividual();
                ab.setAccNo(rs.getString(1));
                dd.add(ab.getAccNo());
            }
            return dd;
        } catch (Exception e) {
            return null;
        }
    }

    public ArrayList<AuthorBook> searchMain(String criteria) {
        try {
            c = new CommonDB().getConnection();
            String q = "select book_master.book_title, book_master.book_price, branch_master.br_name, author_master.author_name from "
                    + "book_individual, book_master, author_master, branch_master where author_master.author_id = book_master.book_author_id1 and "
                    + " book_master.book_br_id = branch_master.br_id and book_master.book_id = book_individual.book_id" + criteria;
            System.out.println(q);
            ps = c.prepareStatement(q);
            rs = ps.executeQuery();
            ArrayList<AuthorBook> dd = new ArrayList<AuthorBook>();
            while (rs.next()) {
                AuthorBook ab = new AuthorBook();
                Book bk = new Book();
                Author au = new Author();
                Branch br = new Branch();
                BookIndividual bi = new BookIndividual();
                bk.setTitle(rs.getString(1));
                bk.setBkPrice(rs.getInt(2));
                br.setBrName(rs.getString(3));
                au.setAuName(rs.getString(4));

                ab.setBook(bk);
                ab.setAuthor(au);
                ab.setBranch(br);
                ab.setBi(bi);
                dd.add(ab);

            }
            rs.close();
            ps.close();
            c.close();
            return dd;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean UpdateBookTable(Integer id) {
        try {
            c = new CommonDB().getConnection();
            ps = c.prepareStatement("update book_individual set avail_flag_id=1, holder_type='N' , holder_id=0 where book_acc_no='" + id + "'");
            System.out.println(ps);
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            return false;
        }

    }


}

 
