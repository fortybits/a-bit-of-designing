package edu.bit.designing.rental.entities;

import edu.bit.designing.rental.branch.Branch;
import lombok.Getter;

import java.util.List;

@Getter
public class City {
    String cityId; //name
    List<Branch> branchList;
}
