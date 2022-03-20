package com.ogoma.vue_starter.vue_starter.boundaries.access_control.services;

import com.ogoma.vue_starter.vue_starter.boundaries.access_control.entities.FamilyMember;
import com.ogoma.vue_starter.vue_starter.boundaries.access_control.models.FamilyMemberModel;
import com.ogoma.vue_starter.vue_starter.boundaries.access_control.repositories.FamilyMemberRepository;
import com.ogoma.vue_starter.vue_starter.utils.SecurityUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class FamilyMemberService {
    private final FamilyMemberRepository memberRepository;

    public FamilyMemberService(FamilyMemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public Optional<FamilyMember> findMemberById(Long id) {
        return memberRepository.findById(id);
    }

    public List<FamilyMember> getAllMembersByUserId(Long userId) {
        return memberRepository.findAll();
    }

    public String addFamilyMembers(FamilyMemberModel model){
        List<FamilyMember> members = new ArrayList<>();
        for (FamilyMemberModel.Member memberModel : model.getMembers()){
            FamilyMember member = saveMember(memberModel, model.getUserId());
            if(null == member){
                return memberModel.getName();
            }
            members.add(member);
        }
        memberRepository.saveAll(members);
        return "members created";
    }

    private FamilyMember saveMember(FamilyMemberModel.Member memberModel, Long employeeId){
        Long userId = SecurityUtils.getCurrentUserDetails().getId();
        FamilyMember member = new FamilyMember();

        if (memberExists(memberModel, employeeId)){
            return null;
        }

        member.setName(memberModel.getName());
        member.setRelationshipId(memberModel.getRelationshipId());
        member.setPhoneNumber(memberModel.getPhoneNumber());
        member.setDob(memberModel.getDob());
        member.setUserId(employeeId);
        member.setCreatedAt(new Date());
        member.setCreatedBy(userId);

        return member;
    }

    public String updateMember(FamilyMemberModel.Member model){
        Long userId = SecurityUtils.getCurrentUserDetails().getId();
        FamilyMember member = findMemberById(model.getId()).get();

        if(!member.getPhoneNumber().equals(model.getPhoneNumber()) || !member.getUserId().equals(model.getUserId())) {
            if (memberExists(model, member.getUserId())) {
                return model.getName();
            }
        }

        member.setName(model.getName());
        member.setRelationshipId(model.getRelationshipId());
        member.setPhoneNumber(model.getPhoneNumber());
        member.setDob(model.getDob());
        member.setUserId(model.getUserId());
        member.setCreatedAt(new Date());
        member.setCreatedBy(userId);

        return "member updated";
    }

    private boolean memberExists(FamilyMemberModel.Member member, Long userId){
        List<FamilyMember> exists = memberRepository.findByPhoneNumberAndUserId(member.getPhoneNumber(),userId);
        return !exists.isEmpty();
    }
}
